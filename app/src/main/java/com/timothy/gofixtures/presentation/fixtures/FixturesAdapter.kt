package com.timothy.gofixtures.presentation.fixtures

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.timothy.gofixtures.databinding.CompetitionItemBinding
import com.timothy.gofixtures.databinding.MatchItemBinding
import com.timothy.gofixtures.domain.model.Competition
import com.timothy.gofixtures.domain.model.Match
import com.timothy.gofixtures.presentation.competition.CompetitionAdapter

class FixturesAdapter :
    ListAdapter<Match, FixturesAdapter.FixViewHolder>(FixDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FixViewHolder {
        return FixViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: FixViewHolder, position: Int) {
        val match = getItem(position)
        holder.bind(match)
    }

    class FixViewHolder(private val binding: MatchItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(match: Match) {
            binding.match = match
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): FixViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = MatchItemBinding.inflate(layoutInflater, parent, false)
                return FixViewHolder(binding)
            }
        }
    }

    class FixDiffUtil : DiffUtil.ItemCallback<Match>() {
        override fun areItemsTheSame(oldItem: Match, newItem: Match): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Match, newItem: Match): Boolean {
            return oldItem == newItem
        }

    }
}