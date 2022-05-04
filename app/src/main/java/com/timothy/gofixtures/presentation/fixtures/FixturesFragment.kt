package com.timothy.gofixtures.presentation.fixtures

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.timothy.gofixtures.R
import com.timothy.gofixtures.databinding.FixturesFragmentBinding
import com.timothy.gofixtures.presentation.competition.CompetitionAdapter
import com.timothy.gofixtures.presentation.competition.CompetitionViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel

@AndroidEntryPoint
class FixturesFragment : Fragment(){

    private lateinit var binding:FixturesFragmentBinding
    private val viewModel by viewModels<CompetitionViewModel>()

    private val fixturesAdapter by lazy { FixturesAdapter() }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FixturesFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fixturesRecycler.adapter = fixturesAdapter
        observeViewModels()

    }

    private fun observeViewModels() {
        with(viewModel) {
            matches.observe(viewLifecycleOwner) { matches ->
                matches?.let {
                    fixturesAdapter.submitList(matches)
                }
            }

            dataFetchState.observe(viewLifecycleOwner) { state ->
                when (state) {
                    true -> {
                        binding.fixturesRecycler.visibility = View.VISIBLE
                        binding.fixturesErrorText.visibility = View.GONE
                    }
                    false -> {
                        binding.fixturesRecycler.visibility = View.VISIBLE
                        binding.apply {
                            fixturesErrorText.visibility = View.VISIBLE
                            fixturesProgress.visibility = View.GONE
                        }
                    }
                }
            }
            loading.observe(viewLifecycleOwner) { state ->
                when (state) {
                    true -> {
                        binding.fixturesRecycler.visibility = View.GONE
                        binding.apply {
                            fixturesProgress.visibility = View.VISIBLE
                        }
                    }
                    false -> {
                        binding.apply {
                            fixturesProgress.visibility = View.GONE
                        }
                    }
                }
            }
        }
    }

}