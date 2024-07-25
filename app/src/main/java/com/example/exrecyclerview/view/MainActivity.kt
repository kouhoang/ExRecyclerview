package com.example.exrecyclerview.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.exrecyclerview.R
import com.example.exrecyclerview.adapter.MyAdapter
import com.example.exrecyclerview.viewmodel.RecyclerViewViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private val viewModel: RecyclerViewViewModel by viewModels()
    private lateinit var adapter: MyAdapter
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_view)
        swipeRefreshLayout = findViewById(R.id.swipe_refresh_layout)
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = MyAdapter(emptyList())
        recyclerView.adapter = adapter

        // Đăng ký Observer để cập nhật Adapter khi dữ liệu thay đổi
        viewModel.liveDataOfList.observe(
            this,
            Observer { data ->
                data?.let {
                    adapter.updateData(it)
                    swipeRefreshLayout.isRefreshing = false
                }
            },
        )

        // Thêm OnScrollListener để theo dõi sự kiện cuộn của RecyclerView
        recyclerView.addOnScrollListener(
            object : RecyclerView.OnScrollListener() {
                override fun onScrolled(
                    recyclerView: RecyclerView,
                    dx: Int,
                    dy: Int,
                ) {
                    super.onScrolled(recyclerView, dx, dy)
                    val layoutManager = recyclerView.layoutManager as LinearLayoutManager
                    // Kiểm tra nếu người dùng đã cuộn đến cuối danh sách
                    if (layoutManager.findLastVisibleItemPosition() >= adapter.itemCount - 1) {
                        // Gọi phương thức loadMoreData() của ViewModel để tải thêm dữ liệu
                        viewModel.loadMoreData()
                    }
                }
            },
        )

        // Thiết lập SwipeRefreshLayout để xử lý refresh
        swipeRefreshLayout.setOnRefreshListener {
            viewModel.fetchSampleData()
        }
    }
}
