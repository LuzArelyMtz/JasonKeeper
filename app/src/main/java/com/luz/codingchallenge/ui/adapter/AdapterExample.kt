package com.luz.codingchallenge.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.luz.codingchallenge.api.model.ItemAPI
import com.luz.codingchallenge.databinding.ItemCardViewBinding

class AdapterExample(private val list: List<ItemAPI>) : RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder =
        MyViewHolder(
            ItemCardViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size
}

class MyViewHolder(val binding: ItemCardViewBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: ItemAPI) {
        binding.tvTitle.text = item.title
        binding.date.text = item.date
        binding.tvDescription.text = item.description
        Glide.with(binding.root.context).load(item.img).into(binding.imgFromJson)
    }
}