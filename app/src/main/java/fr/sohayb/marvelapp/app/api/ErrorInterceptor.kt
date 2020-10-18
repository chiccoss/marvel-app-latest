package fr.sohayb.marvelapp.app.api

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import fr.sohayb.marvelapp.app.error.WSError
import okhttp3.Interceptor
import okhttp3.Response
import timber.log.Timber

class ErrorInterceptor(private val gson: Gson) : Interceptor {

    private object Tag {
        const val interceptorSuccessStart = 200
        const val interceptorSuccessEnd = 299
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val response = chain.proceed(request)

        if (response.code !in Tag.interceptorSuccessStart..Tag.interceptorSuccessEnd) {
            val error: Throwable = try {
                gson.fromJson(response.body?.string(), WSError::class.java)
            } catch (e: Throwable) {
                WSError(
                    response.code,
                    response.message
                )
            }
            Log.i("Error WS :",response.code.toString() + " "+ response.body.toString())
            throw error
        }
        return response
    }
}