package com.rafakob.bitwardenx.rest

import com.rafakob.bitwardenx.environment.EnvironmentApi
import com.rafakob.bitwardenx.rest.url.DefaultUrlProvider
import com.rafakob.bitwardenx.rest.url.UrlProvider
import com.rafakob.bitwardenx.scope.AppScope
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {

    companion object {
        private const val EMPTY_URL = "http://localhost"
    }

    @Provides
    @AppScope
    fun providesOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient =
        OkHttpClient.Builder()
            .apply {
                addInterceptor(httpLoggingInterceptor)
            }
            .build()

    @Provides
    @AppScope
    fun providesHttpLoggingInterceptor(environmentApi: EnvironmentApi): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply {
            level = when (environmentApi.isDebuggable()) {
                true -> HttpLoggingInterceptor.Level.BODY
                false -> HttpLoggingInterceptor.Level.NONE
            }
        }

    @Provides
    @AppScope
    fun providesRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .client(okHttpClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(EMPTY_URL)
            .build()

    @Provides
    @AppScope
    fun providesUrlProvider(): UrlProvider = DefaultUrlProvider()
}