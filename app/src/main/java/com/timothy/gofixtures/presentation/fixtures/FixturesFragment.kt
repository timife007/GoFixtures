package com.timothy.gofixtures.presentation.fixtures

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.timothy.gofixtures.R
import com.timothy.gofixtures.databinding.FixturesFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel

@AndroidEntryPoint
class FixturesFragment : Fragment() {

    private lateinit var binding:FixturesFragmentBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FixturesFragmentBinding.inflate(inflater)
        return binding.root
    }

}