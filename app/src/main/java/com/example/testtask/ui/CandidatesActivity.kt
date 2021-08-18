package com.example.testtask.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testtask.R
import com.example.testtask.entities.Candidate
import com.example.testtask.rv.CandidatesAdapter
import kotlinx.android.synthetic.main.activity_main.*

class CandidatesActivity : AppCompatActivity() {

    private val viewModel: CandidatesViewModel by viewModels()

    private var recyclerAdapter = CandidatesAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initAdapter()
    }

    private fun initAdapter() {
        rv_candidates.layoutManager = LinearLayoutManager(this)
        rv_candidates.adapter = recyclerAdapter
        viewModel.getCandidatesList().observe(this, Observer<List<Candidate>> {
            if (it != null) {
                recyclerAdapter.setList(it)
            } else {
                Toast.makeText(this, "Error is getting data", Toast.LENGTH_SHORT).show()
            }
        })
        viewModel.makeApiCall()
    }
}