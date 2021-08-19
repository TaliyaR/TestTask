package com.example.testtask.ui.rv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testtask.R
import com.example.testtask.entities.Candidate
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_candidate.*


class CanidatesViewHolder(
    override val containerView: View
) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    fun bind(candidate: Candidate) {
        tv_name.text = candidate.name
        tv_city.text = candidate.city
        tv_detail.text = candidate.detail

        Glide.with(containerView.context).load(candidate.image).centerCrop().into(iv_photo)
    }

    companion object {
        fun create(parent: ViewGroup) = CanidatesViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_candidate, parent, false
            )
        )
    }
}