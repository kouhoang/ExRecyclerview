package com.example.exrecyclerview

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private val viewModel: RecyclerViewViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this) // Thêm LayoutManager

        val adapter = MyAdapter(emptyList())
        recyclerView.adapter = adapter

        viewModel.liveDataOfList.observe(
            this,
            Observer { data ->
                data?.let {
                    adapter.updateData(it)
                }
            },
        )
    }
}
