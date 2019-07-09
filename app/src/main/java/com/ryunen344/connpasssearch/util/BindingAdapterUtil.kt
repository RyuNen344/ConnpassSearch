package com.ryunen344.connpasssearch.util

import android.text.SpannableString
import android.text.Spanned
import android.text.style.ClickableSpan
import android.view.View
import android.widget.TextView
import androidx.core.text.HtmlCompat
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ryunen344.connpasssearch.data.Event
import com.ryunen344.connpasssearch.main.EventListAdapter

object BindingAdapterUtil {

    @JvmStatic
    @BindingAdapter("items")
    fun RecyclerView.bindItems(items : MutableList<Event>?) {
        LogUtil.d()

        //items is nullable, so check
        items ?: return

        //  RecyclerView.Adapterを継承しているので、RecyclerViewに設定されているadapterを取得できる
        val adapter = adapter as EventListAdapter
        adapter.update(items)
    }

    @JvmStatic
    @BindingAdapter("hashTag")
    fun setHashTag(view : TextView, hashTagSource : String?) {
        LogUtil.d()

        var hashTag = hashTagSource ?: ""

        var spannableString = SpannableString("#$hashTag")
        spannableString.setSpan(object : ClickableSpan() {
            override fun onClick(textView : View) {
                LogUtil.d()
                //TODO:暗黙的intentでTwitterアプリの検索呼び出し(可能なら)
            }
        }, 0, hashTag.length + 1, Spanned.SPAN_INCLUSIVE_INCLUSIVE)

        view.text = spannableString
    }

    @JvmStatic
    @BindingAdapter("html")
    fun setHtmlText(view : TextView, htmlSource : String?) {
        LogUtil.d()

        view.text = HtmlCompat.fromHtml(htmlSource ?: "", HtmlCompat.FROM_HTML_MODE_COMPACT)
    }
}