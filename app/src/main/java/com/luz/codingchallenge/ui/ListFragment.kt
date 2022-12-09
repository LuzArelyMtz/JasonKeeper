package com.luz.codingchallenge.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.luz.codingchallenge.databinding.ListFragmentBinding
import com.luz.codingchallenge.ui.adapter.AdapterExample
import com.luz.codingchallenge.viewmodel.JsonKeeperVM

class ListFragment : Fragment() {
    private lateinit var binding: ListFragmentBinding
    private lateinit var viewmodel: JsonKeeperVM

    private val listAdapter = AdapterExample(arrayListOf()) { itemSelected ->
        val action = ListFragmentDirections.actionListFragmentToDetailsFragment(itemSelected)
        findNavController().navigate(action)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ListFragmentBinding.inflate(inflater, container, false)
        setupView()
        setupViewModel()
        observeViewModel()
        return binding.root
    }
    private fun setupView() {
        binding.recyclerview.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = listAdapter
        }
    }
    private fun setupViewModel() {
        viewmodel = ViewModelProvider(this)
            .get(JsonKeeperVM::class.java)
    }
    private fun observeViewModel() {
        viewmodel.fetchData()
        viewmodel.response.observe(this as LifecycleOwner, Observer { responseAPI->
            listAdapter.setNewList(responseAPI.items)
        })
        viewmodel.progressBar.observe(this as LifecycleOwner, Observer {
            binding.progressbar.visibility = if (it) View.VISIBLE else View.GONE
        })
        viewmodel.errorMessage.observe(this as LifecycleOwner, Observer {message->
            if (message.isNotEmpty()) {
                Snackbar.make(binding.fragmentListContainer, message, Snackbar.LENGTH_SHORT).show()
            }
        })
    }
}