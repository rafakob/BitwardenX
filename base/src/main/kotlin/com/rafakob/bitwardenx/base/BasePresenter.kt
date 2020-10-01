package com.rafakob.bitwardenx.base

import io.reactivex.disposables.Disposable

abstract class BasePresenter {

    private val disposables: MutableMap<String, MutableList<Disposable>> = HashMap()

    open fun onViewAttached() = Unit
    open fun onViewDetached() = clearDisposables()

    protected fun clearDisposables(tag: String? = null) {
        if (tag != null) {
            disposables[tag]?.forEach { disposable -> disposable.dispose() }
            disposables.remove(tag)
        } else {
            disposables.forEach { it.value.forEach { disposable -> disposable.dispose() } }
            disposables.clear()
        }
    }

    protected fun Disposable.addToDisposables(tag: String = javaClass.simpleName): Disposable = apply {
        if (disposables.contains(tag).not()) {
            disposables[tag] = mutableListOf()
        }

        disposables[tag]?.add(this)
    }
}