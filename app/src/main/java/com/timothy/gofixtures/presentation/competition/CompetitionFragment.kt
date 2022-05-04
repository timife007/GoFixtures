package com.timothy.gofixtures.presentation.competition

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.timothy.gofixtures.R
import com.timothy.gofixtures.databinding.CompetitionFragmentBinding
import com.timothy.gofixtures.domain.model.Competition
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CompetitionFragment : Fragment(),CompetitionAdapter.CompClickListener {

    private lateinit var binding : CompetitionFragmentBinding
    val viewModel by viewModels<CompetitionViewModel>()

    private val competitionAdapter by lazy { CompetitionAdapter(this) }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = CompetitionFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.competitionRecycler.adapter = competitionAdapter


    }

    override fun onClick(competition: Competition) {
        viewModel.getMatches(competition.id)
    }
}