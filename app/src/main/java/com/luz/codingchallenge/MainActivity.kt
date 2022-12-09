package com.luz.codingchallenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.luz.codingchallenge.databinding.ActivityMainBinding
import com.luz.codingchallenge.ui.adapter.AdapterExample
import com.luz.codingchallenge.viewmodel.JsonKeeperVM

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}