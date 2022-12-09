package com.luz.codingchallenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.luz.codingchallenge.databinding.ActivityMainBinding
import com.luz.codingchallenge.ui.adapter.AdapterExample
import com.luz.codingchallenge.viewmodel.JsonKeeperVM

class MainActivity : AppCompatActivity() {

    private lateinit var viewmodel: JsonKeeperVM
    private lateinit var adapter: AdapterExample

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewmodel = ViewModelProvider(this)[JsonKeeperVM::class.java]
        binding.recyclerview.layoutManager = LinearLayoutManager(this)

        viewmodel.fetchData()
        viewmodel.livedata.observe(this, Observer { resposeAPI ->
            adapter = AdapterExample(resposeAPI.items)
            binding.recyclerview.adapter = adapter

        })
    }
}