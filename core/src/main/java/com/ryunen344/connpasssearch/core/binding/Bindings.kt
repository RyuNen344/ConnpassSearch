package com.ryunen344.connpasssearch.core.binding

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ClickableSpan
import android.view.View
import android.widget.TextView
import androidx.core.text.HtmlCompat
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import com.ryunen344.connpasssearch.core.util.AndroidRInteger

@BindingAdapter("isVisible")
fun View.showGone(show: Boolean) {
    isVisible = show
}

@BindingAdapter("isInvisible")
fun View.showHide(invisible: Boolean) {
    isInvisible = invisible
}

@BindingAdapter("isVisibleWithAnimation")
fun View.showGoneWithAnimation(show: Boolean) {
    val animationDuration = resources.getInteger(AndroidRInteger.config_longAnimTime)
    val endOpacity = if (show) 100f else 0f
    val endVisible = if (show) View.VISIBLE else View.GONE
    animate()
        .alpha(endOpacity)
        .setDuration(animationDuration.toLong())
        .setListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator) {
                visibility = endVisible
            }
        })
}

@BindingAdapter("isHideWithAnimation")
fun View.showHideWithAnimation(show: Boolean) {
    val animationDuration = resources.getInteger(AndroidRInteger.config_longAnimTime)
    val endOpacity = if (show) 100f else 0f
    val endVisible = if (show) View.VISIBLE else View.INVISIBLE
    animate()
        .alpha(endOpacity)
        .setDuration(animationDuration.toLong())
        .setListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator) {
                visibility = endVisible
            }
        })
}

@BindingAdapter("hashTag")
fun setHashTag(view: TextView, hashTagSource: String?) {
    val hashTag = hashTagSource ?: ""

    val spannableString = SpannableString("#$hashTag")
    spannableString.setSpan(object : ClickableSpan() {
        override fun onClick(textView: View) {
            //TODO:暗黙的intentでTwitterアプリの検索呼び出し(可能なら)
        }
    }, 0, hashTag.length + 1, Spanned.SPAN_INCLUSIVE_INCLUSIVE)

    view.text = spannableString
}

@BindingAdapter("html")
fun setHtmlText(view: TextView, htmlSource: String?) {
    view.text = HtmlCompat.fromHtml(htmlSource ?: "", HtmlCompat.FROM_HTML_MODE_COMPACT)
}
