package fr.sohayb.marvelapp.app.injection

import com.google.gson.Gson
import com.google.gson.GsonBuilder

import fr.sohayb.marvelapp.app.api.AuthenticatorInterceptor
import fr.sohayb.marvelapp.app.api.ErrorInterceptor
import fr.sohayb.marvelapp.app.api.NetworkService
import fr.sohayb.marvelapp.utils.baseURL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val NetworkModule = module {

    single {
        HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
    }

    single<Gson> {
        GsonBuilder().setLenient().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZZZZZ").create()
    }

    single {
        ErrorInterceptor(get())
    }

    single {
        AuthenticatorInterceptor()
    }

    single {

        OkHttpClient.Builder()
            .addInterceptor(get<HttpLoggingInterceptor>())
            .addInterceptor(get<ErrorInterceptor>())
            .addInterceptor(get<AuthenticatorInterceptor>())
            //.sslSocketFactory(get(),get())
            .build()
        //.connectionSpecs(Collections.singletonList(spec))
    }

    single<Retrofit> {
        Retrofit.Builder()
            .client(get())
            .baseUrl(baseURL)
            .addConverterFactory(
                GsonConverterFactory.create()
            )
            .build()
    }

    single<NetworkService> {
        val retrofit = get<Retrofit>()
        retrofit.create(NetworkService::class.java)
    }

}
