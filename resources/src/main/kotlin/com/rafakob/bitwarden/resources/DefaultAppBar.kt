package com.rafakob.bitwarden.resources

import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import androidx.annotation.StringRes
import com.google.android.material.appbar.AppBarLayout
import com.rafakob.bitwarden.resources.extensions.readString
import kotlinx.android.synthetic.main.layout_default_toolbar.view.*


class DefaultAppBar : AppBarLayout {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, attributeSetId: Int) : super(context, attrs, attributeSetId)

    init {
        inflate(context, R.layout.layout_default_appbar, this)
    }

    fun setToolbarTitle(@StringRes res: Int? = null, text: String? = null) {
        toolbar.title = context.readString(res, text)
    }

    fun setToolbarBackButton(activity: Activity?, click: (() -> Unit)? = null) {
        toolbar.setNavigationIcon(R.drawable.ic_back)
        toolbar.setNavigationOnClickListener { click?.invoke() ?: activity?.onBackPressed() }
    }
}