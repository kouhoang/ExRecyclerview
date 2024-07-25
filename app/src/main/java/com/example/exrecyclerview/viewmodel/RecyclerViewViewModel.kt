package com.example.exrecyclerview.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.exrecyclerview.R
import com.example.exrecyclerview.model.MyData

class RecyclerViewViewModel : ViewModel() {
    // LiveData chứa danh sách dữ liệu để cập nhật RecyclerView
    val liveDataOfList = MutableLiveData<List<MyData>>()

    private val initialData =
        listOf(
            MyData(R.drawable.toanchuccaothu, "Toàn chức cao thủ", "Hồ Điệp Lam", 1765, listOf("Võng Du", "Hài Hước")),
            MyData(R.drawable.dauladailuc, "Đấu La đại lục", "Đường Gia Tam Thiếu", 517, listOf("Tiên Hiệp", "Huyền Huyễn")),
            MyData(
                R.drawable.dauphathuongkhung,
                "Đấu phá thương khung",
                "Thiên Tàm Thổ Đậu",
                1641,
                listOf("Tiên Hiệp", "Dị Giới", "Huyền Huyễn"),
            ),
            MyData(R.drawable.vudongcankhon, "Vũ động càn khôn", "Thiên Tàm Thổ Đậu", 1309, listOf("Tiên Hiệp", "Huyền Huyễn")),
            MyData(R.drawable.nguyenton, "Nguyên Tôn", "Thiên Tàm Thổ Đậu", 1502, listOf("Tiên Hiệp", "Huyền Huyễn")),
            MyData(R.drawable.daichuate, "Vũ động càn khôn", "Thiên Tàm Thổ Đậu", 1563, listOf("Tiên Hiệp", "Huyền Huyễn", "Dị Giới")),
            MyData(R.drawable.tamthe, "Tam thể", "Lưu Từ Hân", 38, listOf("Khoa Học", "Viễn Tưởng")),
            MyData(R.drawable.thegioihoanmy, "Thế giới hoàn mỹ", "Thần Đông", 2015, listOf("Tiên Hiệp", "Kiếm Hiệp", "Huyền Huyễn")),
            MyData(R.drawable.giathien, "Già Thiên", "Thần Đông", 1896, listOf("Tiên Hiệp", "Dị Giới")),
            MyData(R.drawable.thanhkhu, "Thánh Khư", "Thần Đông", 1670, listOf("Tiên Hiệp", "Huyền Huyễn")),
            MyData(R.drawable.quybichichu, "Quỷ Bí Chi Chủ", "Ái Tiềm Thủy Đích Ô Tặc", 1412, listOf("Huyền Huyễn")),
            MyData(R.drawable.phamnhantutien, "Phàm Nhân tu tiên", "Vong Ngữ", 2468, listOf("Tiên Hiệp", "Kiếm Hiệp")),
            MyData(
                R.drawable.phamnhantutientiengioithien,
                "Phàm Nhân tu tiên - Tiên Giới Thiên",
                "Vong Ngữ",
                1397,
                listOf("Tiên Hiệp", "Huyền Huyễn"),
            ),
            MyData(R.drawable.mucthanky, "Mục Thần ký", "Trạch Trư", 1844, listOf("Huyền Huyễn", "Hài Hước", "Chính trị")),
            MyData(R.drawable.trutien, "Tru Tiên", "Tiêu Đỉnh", 258, listOf("Tiên Hiệp", "Kiếm Hiệp")),
            MyData(
                R.drawable.tuyettrunghandaohanh,
                "Tuyết Trung Hãn Đao Hành",
                "Phong Hỏa Hí Chư Hầu",
                997,
                listOf("Huyền Huyễn", "Kiếm Hiệp"),
            ),
            MyData(R.drawable.kiemlai, "Kiếm Lai", "Phong Hỏa Hí Chư Hầu", 997, listOf("Tiên Hiệp", "Kiếm Hiệp")),
            MyData(R.drawable.deba, "Đế Bá", "Yểm Bút Tiêu Sinh", 7195, listOf("Huyền Huyễn")),
            MyData(R.drawable.nhatniemvinhhang, "Nhất niệm vĩnh hằng", "Nhĩ Căn", 1981, listOf("Tiên Hiệp", "Huyền Huyễn")),
            MyData(R.drawable.cochannhan, "Cổ Chân Nhân", "Cổ Chân Nhân", 2333, listOf("Tiên Hiệp", "Huyền Huyễn", "Xuyên Không")),
            MyData(R.drawable.tinhthanbien, "Tinh Thần Biến", "Ngã Cật Tây Hồng Thị", 671, listOf("Tiên Hiệp", "Kiếm Hiệp")),
            MyData(R.drawable.phieumieuchilu, "Phiêu Miểu Chi Lữ", "Tiêu Điềm", 304, listOf("Tiên Hiệp", "Dị Giới")),
        )

    private val recyclerItemModels = ArrayList<MyData>()
    private var currentPage = 0
    private val pageSize = 20
    private val itemsPerPage = 20
    private val repeatCount = 10

    init {
        fetchSampleData()
    }

    internal fun fetchSampleData() {
        recyclerItemModels.clear()
        for (i in 1..repeatCount) {
            for (item in initialData) {
                recyclerItemModels.add(item.copy(title = "${item.title} $i"))
            }
        }
        liveDataOfList.value = getRandomData(recyclerItemModels)
    }

    fun loadMoreData() {
        // Xác định phạm vi dữ liệu mới cần tải
        val start = (currentPage + 1) * pageSize + 1
        val end = start + pageSize - 1

        // Danh sách lưu trữ dữ liệu mới
        val newData = ArrayList<MyData>()
        for (i in start..end) {
            // Lấy dữ liệu mẫu và tạo dữ liệu mới với tiêu đề được thay đổi
            val originalItem = initialData[(i - 1) % initialData.size]
            newData.add(originalItem.copy(title = "${originalItem.title} $i"))
        }

        // Cập nhật danh sách dữ liệu hiện tại với dữ liệu mới và trộn ngẫu nhiên
        val updatedList = recyclerItemModels.toMutableList().apply { addAll(newData) }
        recyclerItemModels.clear()
        recyclerItemModels.addAll(getRandomData(updatedList))
        liveDataOfList.value = recyclerItemModels

        currentPage++
    }

    fun refreshData() {
        currentPage = 0
        fetchSampleData()
        loadMoreData()
    }

    private fun getRandomData(data: List<MyData>): List<MyData> = data.shuffled()
}
