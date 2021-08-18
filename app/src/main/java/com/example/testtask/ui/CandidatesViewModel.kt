package com.example.testtask.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testtask.entities.Candidate
import com.example.testtask.model.repository.CandidatesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CandidatesViewModel constructor(
    private val repository: CandidatesRepository = CandidatesRepository()
) : ViewModel() {

    lateinit var candidates: MutableLiveData<List<Candidate>>

    init {
        candidates = MutableLiveData()
    }

    fun getCandidatesList(): MutableLiveData<List<Candidate>> = candidates

    fun makeApiCall() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.getCandidates()
            candidates.postValue(response)
        }
    }
}