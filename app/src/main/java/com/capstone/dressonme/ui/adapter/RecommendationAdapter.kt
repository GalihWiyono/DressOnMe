package com.capstone.dressonme.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.capstone.dressonme.model.Picture
import com.capstone.dressonme.ui.callback.ItemsCallback
import com.capstone.dressonme.databinding.ItemRecommendationBinding

class RecommendationAdapter : RecyclerView.Adapter<RecommendationAdapter.ViewHolder>() {

    private val listItemsRecommendation = ArrayList<Picture>()

    fun setListRecommendation(listItems : List<Picture>) {
        val diffListCallback = ItemsCallback(this.listItemsRecommendation, listItems)
        val resultCallback = DiffUtil.calculateDiff(diffListCallback)
        this.listItemsRecommendation.clear()
        this.listItemsRecommendation.addAll(listItems)
        resultCallback.dispatchUpdatesTo(this)
    }

    inner class ViewHolder(val binding: ItemRecommendationBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemRecommendationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val context = holder.itemView.context
        val dataPosition = listItemsRecommendation[position]
        Glide.with(context).load(dataPosition.photo).into(holder.binding.imageRecommendation)
    }

    override fun getItemCount(): Int = listItemsRecommendation.size
}