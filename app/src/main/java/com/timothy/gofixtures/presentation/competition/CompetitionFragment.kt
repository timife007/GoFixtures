package com.timothy.gofixtures.presentation.competition

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.timothy.gofixtures.R
import com.timothy.gofixtures.databinding.CompetitionFragmentBinding
import com.timothy.gofixtures.domain.model.Competition
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CompetitionFragment : Fragment(),CompetitionAdapter.CompClickListener {

    private lateinit var binding : CompetitionFragmentBinding
    private val viewModel by viewModels<CompetitionViewModel>()

    private val competitionAdapter by lazy { CompetitionAdapter(this) }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = CompetitionFragmentBinding.inflate(inflater)
        return binding.root
    }

//    override fun onStart() {
//        super.onStart()
//        viewModel.getCompetition()
//    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.competitionRecycler.adapter = competitionAdapter
        observeViewModels()
        binding.competitionSwipeRefresh.setOnRefreshListener {
            binding.competitionErrorText.visibility = View.GONE
            binding.competitionProgress.visibility = View.VISIBLE
            binding.competitionRecycler.visibility = View.GONE
            initiateRefresh()
            binding.competitionSwipeRefresh.isRefreshing = false
        }

        viewModel.navigateToSelectedCompetition.observe(viewLifecycleOwner) {
            if (null != it) {
                this.findNavController()
                    .navigate(CompetitionFragmentDirections.actionCompetitionFragmentToFixturesFragment(it))
            }
        }
    }

    private fun initiateRefresh() {
        viewModel.refreshCompetition()
    }

    private fun observeViewModels() {
        with(viewModel) {
            competition.observe(viewLifecycleOwner) { competition ->
                competition?.let {
                    Toast.makeText(requireContext(),"$it",Toast.LENGTH_LONG).show()
                    competitionAdapter.submitList(competition)
                }
            }

            dataFetchState.observe(viewLifecycleOwner) { state ->
                when (state) {
                    true -> {
                        binding.competitionRecycler.visibility = View.VISIBLE
                        binding.competitionErrorText.visibility = View.GONE
                    }
                    false -> {
                        binding.competitionRecycler.visibility = View.VISIBLE
                        binding.apply {
                            competitionErrorText.visibility = View.VISIBLE
                            competitionProgress.visibility = View.GONE
                        }
                    }
                }
            }
            loading.observe(viewLifecycleOwner) { state ->
                when (state) {
                    true -> {
                        binding.competitionRecycler.visibility = View.GONE
                        binding.apply {
                            competitionProgress.visibility = View.VISIBLE
                        }
                    }
                    false -> {
                        binding.apply {
                            competitionProgress.visibility = View.GONE
                        }
                    }
                }
            }
        }
    }


    override fun onClick(competition: Competition) {
        viewModel.getMatches(competition.id)
        Toast.makeText(requireContext(),"$competition.id",Toast.LENGTH_LONG).show()
    }
}