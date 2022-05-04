package com.timothy.gofixtures.presentation.competition

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.timothy.gofixtures.databinding.CompetitionItemBinding
import com.timothy.gofixtures.domain.model.Competition

class CompetitionAdapter (private val clickListener: CompClickListener) :
    ListAdapter<Competition, CompetitionAdapter.CompViewHolder>(VenuesDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompViewHolder {
        return CompViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: CompViewHolder, position: Int) {
        val comp = getItem(position)
        holder.bind(comp)
        holder.itemView.setOnClickListener {
            clickListener.onClick(comp)
        }
    }

    class CompViewHolder(private val binding: CompetitionItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(competition: Competition) {
            binding.competition = competition
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): CompViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = CompetitionItemBinding.inflate(layoutInflater, parent, false)
                return CompViewHolder(binding)
            }
        }
    }

    class VenuesDiffUtil : DiffUtil.ItemCallback<Competition>() {
        override fun areItemsTheSame(oldItem: Competition, newItem: Competition): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Competition, newItem: Competition): Boolean {
            return oldItem == newItem
        }

    }

    interface CompClickListener {
        fun onClick(competition: Competition)
    }
}