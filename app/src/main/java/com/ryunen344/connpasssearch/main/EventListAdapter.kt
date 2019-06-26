package com.ryunen344.connpasssearch.main

import android.view.View
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ryunen344.connpasssearch.data.Event
import com.ryunen344.connpasssearch.util.LogUtil

class EventListAdapter : RecyclerView.Adapter<EventListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        LogUtil.d()
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        LogUtil.d()
        return 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        LogUtil.d()
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    companion object {
        @JvmStatic
        @BindingAdapter("items")
        fun RecyclerView.bindItems(items: List<Event>?) {

            // まだ情報が取得できていない場合はitemsがnullになる可能性があるため、nullチェック必須。
            if (items == null) {
                return
            }

            //  RecyclerView.Adapterを継承しているので、RecyclerViewに設定されているadapterを取得できる
            val adapter = adapter as EventListAdapter
        }
    }
}