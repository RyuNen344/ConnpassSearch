package com.ryunen344.connpasssearch.feature.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ryunen344.connpasssearch.feature.main.databinding.ItemEventBinding
import com.ryunen344.connpasssearch.model.Event

class EventListAdapter : ListAdapter<Event, EventListAdapter.ViewHolder>(
    object : DiffUtil.ItemCallback<Event>() {
        override fun areItemsTheSame(oldItem: Event, newItem: Event): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Event, newItem: Event): Boolean {
            return oldItem.eventId == newItem.eventId
        }
    }
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_event,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        (holder.binding as ItemEventBinding).item = getItem(position)
        holder.binding.setClickListener {
            //            val directions = MainFragmentDirections.actionToDetail(getItem(position).event_id)
//            it.findNavController().navigate(directions)
        }
        holder.itemView.setOnClickListener {


        }
        holder.binding.executePendingBindings()
    }

    class ViewHolder(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root)
}
