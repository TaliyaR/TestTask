package com.example.testtask.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testtask.R
import com.example.testtask.entities.Candidate
import com.example.testtask.presenter.CandidatesViewModel
import com.example.testtask.ui.rv.CandidatesAdapter
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_main.*

class CandidatesActivity : AppCompatActivity() {

    private val viewModel: CandidatesViewModel by viewModels()

    private var recyclerAdapter = CandidatesAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        supportActionBar?.title = null

        initAdapter()
        fab.setOnClickListener {
            MaterialAlertDialogBuilder(this)
                .setMessage(R.string.alert)
                .setPositiveButton(R.string.alert_button, null)
                .show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.top_app_bar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.action_profile -> {
            MaterialAlertDialogBuilder(this)
                .setMessage(R.string.alert)
                .setPositiveButton(R.string.alert_button, null)
                .show()
            true
        }
        else -> {
            super.onOptionsItemSelected(item)
        }
    }

    private fun initAdapter() {
        rv_candidates.layoutManager = LinearLayoutManager(this)
        rv_candidates.adapter = recyclerAdapter
        viewModel.getCandidatesList().observe(this, Observer<List<Candidate>> {
            if (it != null) {
                recyclerAdapter.setList(it)
                tv_number.text = it.size.toString()
            } else {
                Toast.makeText(this, "Error is getting data", Toast.LENGTH_SHORT).show()
            }
        })
        viewModel.makeApiCall()
    }
}