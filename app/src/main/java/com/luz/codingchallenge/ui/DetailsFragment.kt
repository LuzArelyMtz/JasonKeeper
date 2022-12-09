package com.luz.codingchallenge.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.luz.codingchallenge.api.model.ItemAPI
import com.luz.codingchallenge.databinding.DetailFragmentBinding

class DetailsFragment : Fragment() {

    private lateinit var binding: DetailFragmentBinding
    private val args: DetailsFragmentArgs by navArgs()
    private lateinit var itemAPI: ItemAPI

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DetailFragmentBinding.inflate(inflater, container, false)

        itemAPI = args.itemAPI

        setupView()

        return binding.root
    }
    private fun setupView() {
        binding.apply {
            tvTitleDetails.text = itemAPI.title
            tvDescriptionDetails.text = itemAPI.description
            dateDetails.text = itemAPI.date
            Glide.with(binding.root.context).load(itemAPI.img).into(binding.imgFromJsonDetails)
        }
    }
}