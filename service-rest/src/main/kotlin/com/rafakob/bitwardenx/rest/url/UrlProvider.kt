package com.rafakob.bitwardenx.rest.url

interface UrlProvider {
    fun getBitwardenUrl(): String
    fun getIdentityUrl(): String
    fun getVaultUrl(): String
}