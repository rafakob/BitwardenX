package com.rafakob.bitwardenx.startup

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import kotlinx.android.synthetic.main.view_loading_button.view.*


class LoadingMaterialButton @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr), LoadingButton {

    enum class State {
        NORMAL, LOADING,
    }

    private var state: State = State.NORMAL
    private val normalText: String
    private val loadingText: String

    init {
        View.inflate(context, R.layout.view_loading_button, this)

        context.theme.obtainStyledAttributes(attrs, R.styleable.LoadingMaterialButton, 0, 0)
                .apply {
                    try {
                        normalText = getString(R.styleable.LoadingMaterialButton_normalText) ?: ""
                        loadingText = getString(R.styleable.LoadingMaterialButton_loadingText) ?: ""

                        val minHeight = getDimensionPixelSize(
                                R.styleable.LoadingMaterialButton_android_minHeight,
                                0
                        )

                        if (minHeight != 0) {
                            button.minHeight = minHeight
                        }
                    } finally {
                        recycle()
                    }
                }

        state = State.NORMAL
        text.text = normalText
    }

    private fun animateToLoadingState(loadingText: String) {
        state = State.LOADING
        if (icon.alpha > 0) animOut(icon)

        animOut(text) {
            text.text = loadingText
            animIn(text)
            if (progress.alpha == 0f) animIn(progress)
        }
    }

    private fun animateToNormalState(normalText: String) {
        state = State.NORMAL
        if (progress.alpha > 0) animOut(progress)
        if (icon.alpha > 0) animOut(icon)

        animOut(text) {
            text.text = normalText
            animIn(text)
        }
    }

    private fun animIn(view: View, onEnd: () -> Unit = {}) {
        YoYo.with(Techniques.FadeInUp)
                .duration(200)
                .onEnd { onEnd.invoke() }
                .playOn(view)
    }

    private fun animOut(view: View, onEnd: () -> Unit = {}) {
        YoYo.with(Techniques.FadeOutDown)
                .duration(200)
                .onEnd { onEnd.invoke() }
                .playOn(view)
    }

    override fun setOnClickListener(action: OnClickListener?) {
        button.setOnClickListener {
            if (state == State.NORMAL) {
                action?.onClick(button)
                showLoading()
            }
        }
    }

    override fun setEnabled(enabled: Boolean) {
        button.isEnabled = enabled
    }

    override fun showLoading() = animateToLoadingState(loadingText)

    override fun showNormal() = animateToNormalState(normalText)
}