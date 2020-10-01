package com.rafakob.bitwardenx.resources.extensions

import android.content.Context
import androidx.annotation.StringRes

fun Context.readString(@StringRes res: Int?, text: String?) =
    text ?: res?.let { getString(it) } ?: throw IllegalArgumentException()