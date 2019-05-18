package com.rafakob.bitwarden.rest.url

class DefaultUrlProvider : UrlProvider {
    override fun getBitwardenUrl() = "https://api.bitwarden.com"
    override fun getIdentityUrl() = "https://identity.bitwarden.com"
    override fun getVaultUrl() = "https://vault.bitwarden.com"
}