package com.fifththirdbankcc.di

import com.fifththirdbankcc.rest.JokeRepository
import com.fifththirdbankcc.rest.JokeRepositoryImpl
import com.fifththirdbankcc.rest.JokeService
import com.fifththirdbankcc.viewmodel.DailyJokeViewModel
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {

    fun provideJokeRepo(jokeServiceApi: JokeService): JokeRepository = JokeRepositoryImpl(jokeServiceApi)

    fun provideGson() = GsonBuilder().create()

    fun provideLoggingInterceptor() =
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor) =
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()


    fun provideJokeServiceApi(okHttpClient: OkHttpClient, gson: Gson): JokeService =
        Retrofit.Builder()
            .baseUrl(JokeService.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient)
            .build()
            .create(JokeService::class.java)

    single { provideGson() }
    single { provideLoggingInterceptor() }
    single { provideOkHttpClient(get()) }
    single { provideJokeServiceApi(get(), get()) }
    single { provideJokeRepo(get()) }
}

val viewModelModule = module {
    viewModel { DailyJokeViewModel(get()) }
}