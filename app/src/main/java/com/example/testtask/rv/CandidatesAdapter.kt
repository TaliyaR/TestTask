package com.example.testtask.rv

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testtask.entities.Candidate

class CandidatesAdapter(
    private var data: List<Candidate> = emptyList()
) : RecyclerView.Adapter<CanidatesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CanidatesViewHolder =
        CanidatesViewHolder.create(parent)

    override fun onBindViewHolder(holder: CanidatesViewHolder, position: Int) =
        holder.bind(data[position])

    override fun getItemCount(): Int = data.size

    fun setList(list: List<Candidate>) {
        data = list
        notifyDataSetChanged()
    }
}