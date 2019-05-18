package com.rafakob.bitwarden.rest

import com.rafakob.bitwarden.environment.EnvironmentApi
import com.rafakob.bitwarden.rest.retrofit.BitwardenApi
import com.rafakob.bitwarden.rest.retrofit.IdentityApi
import com.rafakob.bitwarden.rest.retrofit.VaultApi
import com.rafakob.bitwarden.scope.AppScope
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

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
        when (environmentApi.isDebuggable()) {
            true -> HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
            false -> HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.NONE)
        }

    @Provides
    @AppScope
    fun providesRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(EMPTY_URL)
            .build()

    @Provides
    @AppScope
    fun providesBitwardenApi(retrofit: Retrofit): BitwardenApi = retrofit.create(BitwardenApi::class.java)

    @Provides
    @AppScope
    fun providesIdentityApi(retrofit: Retrofit): IdentityApi = retrofit.create(IdentityApi::class.java)

    @Provides
    @AppScope
    fun providesVaultApi(retrofit: Retrofit): VaultApi = retrofit.create(VaultApi::class.java)
}