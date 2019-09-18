package com.rafakob.bitwarden.base

interface BasePresenter {
    fun onViewAttached() = Unit
    fun onViewDetached() = Unit
}