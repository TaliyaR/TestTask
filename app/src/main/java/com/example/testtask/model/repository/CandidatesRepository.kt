package com.example.testtask.model.repository

import com.example.testtask.model.data.server.ApiFactory
import com.example.testtask.model.data.server.CandidatesApi

class CandidatesRepository(
    private val api: CandidatesApi = ApiFactory.candidatesApi
) {

    suspend fun getCandidates() = api.getCandidatesList()
}