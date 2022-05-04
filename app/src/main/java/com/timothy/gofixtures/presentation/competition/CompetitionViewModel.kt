package com.timothy.gofixtures.presentation.competition

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.timothy.gofixtures.domain.model.Competition
import com.timothy.gofixtures.domain.model.Match
import com.timothy.gofixtures.domain.repository.FixturesRepo
import com.timothy.gofixtures.util.asLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.timothy.gofixtures.util.Result

@HiltViewModel
class CompetitionViewModel @Inject constructor(
    private val repository: FixturesRepo
) : ViewModel() {

    private val _competition = MutableLiveData<List<Competition>?>()
    val competition = _competition.asLiveData()
    private val _matches = MutableLiveData<List<Match>?>()
    val matches = _matches.asLiveData()

    private val _loading = MutableLiveData<Boolean>()
    val loading = _loading.asLiveData()

    private val _dataFetchState = MutableLiveData<Boolean>()
    val dataFetchState = _dataFetchState.asLiveData()


    /**
     * This is a caching strategy, checks the local database for data, if empty it calls
     * refresh to fetch from remote source
     */

    fun getCompetition() {
        _loading.postValue(true)
        viewModelScope.launch {
            when (val result = repository.getCompetitions(false)) {
                is Result.Success -> {
                    _loading.value=false
                    if (!result.data.isNullOrEmpty()) {
                        val competition = result.data
                        _dataFetchState.value = true
                        _competition.value = competition
                    } else {
                        refreshCompetition()
                    }
                }
                is Result.Loading -> _loading.postValue(true)
                is Result.Error -> {
                    _loading.value = false
                    _dataFetchState.value = false
                }
            }
        }
    }

    fun refreshCompetition() {
        _loading.value = true
        viewModelScope.launch {
            when (val result = repository.getCompetitions(true)) {
                is Result.Success -> {
                    _loading.value = false
                    if (result.data != null) {
                        val competitionData = result.data
                        _competition.value = competitionData
                        _dataFetchState.value = true
                        repository.deleteCachedCompetition()
                        repository.saveCompetition(competitionData)
                    } else {
                        _dataFetchState.postValue(false)
                        _competition.postValue(null)
                    }
                }

                is Result.Error -> {
                    _dataFetchState.value = false
                    _loading.value = false
                }

                is Result.Loading -> _loading.postValue(true)
            }
        }
    }

    fun getMatches(id:Int) {
        _loading.postValue(true)
        viewModelScope.launch {
            when (val result = repository.getFixtures(id)) {
                is Result.Success -> {
                    _loading.value=false
                    if (!result.data.isNullOrEmpty()) {
                        val matches = result.data
                        _dataFetchState.value = true
                        _matches.value = matches
                    } else {
//                        refreshMatches()
                    }
                }
                is Result.Loading -> _loading.postValue(true)
                is Result.Error -> {
                    _loading.value = false
                    _dataFetchState.value = false
                }
            }
        }
    }
}