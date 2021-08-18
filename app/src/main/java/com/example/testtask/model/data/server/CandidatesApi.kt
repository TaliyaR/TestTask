package com.example.testtask.model.data.server

import com.example.testtask.entities.Candidate
import retrofit2.http.GET

interface CandidatesApi {
    @GET("simpledimple")
    suspend fun getCandidatesList(): List<Candidate>
}