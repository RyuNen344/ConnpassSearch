package com.ryunen344.connpasssearch.feature.main.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.ryunen344.connpasssearch.feature.main.R
import com.ryunen344.connpasssearch.feature.main.databinding.ItemEventBinding
import com.ryunen344.connpasssearch.model.Event

class SearchAdapter(private val searchViewModel: SearchViewModel) :
    RecyclerView.Adapter<SearchAdapter.ViewHolder>() {

    private var eventList: MutableList<Event> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent)
    }

    override fun getItemCount(): Int {
        return eventList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //set click listener
        holder.binding.root.setOnClickListener {
            searchViewModel.itemClick(eventList[position].eventId)
        }

        holder.binding.item = eventList[position]
        holder.binding.executePendingBindings()
    }

    fun update(eventList: MutableList<Event>) {
        this.eventList = eventList
        notifyDataSetChanged()
    }

    class ViewHolder(
        private val parent: ViewGroup,
        val binding: ItemEventBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_event,
            parent,
            false
        )
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(event: Event) {
            binding.item = event
        }

    }

    companion object {

        @JvmStatic
        @BindingAdapter("items_search")
        fun RecyclerView.bindItems(items: MutableList<Event>?) {

            //items is nullable, so check
            items ?: return

            //  RecyclerView.Adapterを継承しているので、RecyclerViewに設定されているadapterを取得できる
            val adapter = adapter as SearchAdapter
            adapter.update(items)
        }
    }
}
