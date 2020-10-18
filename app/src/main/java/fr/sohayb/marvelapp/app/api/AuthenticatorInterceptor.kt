package fr.sohayb.marvelapp.app.api


import fr.sohayb.marvelapp.utils.privateKey
import fr.sohayb.marvelapp.utils.publicKey
import okhttp3.Interceptor
import okhttp3.Interceptor.Chain
import okhttp3.Request
import okhttp3.Response
import java.security.MessageDigest

class AuthenticatorInterceptor : Interceptor {

    override fun intercept(chain: Chain): Response {
        val original: Request = chain.request()
        val originalHttpUrl = original.url
        val timeStamp = System.currentTimeMillis()
        val hashGenerator = AuthHashGenerator()
        val hash = hashGenerator.generateHash(timeStamp, publicKey, privateKey)
        val url = originalHttpUrl.newBuilder()
            .addQueryParameter("ts", "$timeStamp")
            .addQueryParameter("apikey", publicKey)
            .addQueryParameter("hash", hash)
            .build()
        val requestBuilder = original.newBuilder().url(url)
        val request = requestBuilder.build()
        return chain.proceed(request)
    }
}