package com.example.exrecyclerview

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RecyclerViewViewModel : ViewModel() {
    val liveDataOfList = MutableLiveData<ArrayList<MyData>>()

    private val recyclerItemModels = ArrayList<MyData>()

    init {
        fetchSampleData()
    }

    private fun fetchSampleData() {
        recyclerItemModels.clear()

        recyclerItemModels.add(
            MyData(
                R.drawable.toanchuccaothu,
                "Toàn chức cao thủ",
                "Hồ Điệp Lam",
                1765,
                listOf("Võng Du", "Hài Hước"),
            ),
        )
        recyclerItemModels.add(
            MyData(
                R.drawable.dauladailuc,
                "Đấu La đại lục",
                "Đường Gia Tam Thiếu",
                517,
                listOf("Tiên Hiệp", "Huyền Huyễn"),
            ),
        )

        recyclerItemModels.add(
            MyData(
                R.drawable.dauphathuongkhung,
                "Đấu phá thương khung",
                "Thiên Tàm Thổ Đậu",
                1641,
                listOf("Tiên Hiệp", "Dị Giới", "Huyền Huyễn"),
            ),
        )

        recyclerItemModels.add(
            MyData(
                R.drawable.vudongcankhon,
                "Vũ động càn khôn",
                "Thiên Tàm Thổ Đậu",
                1309,
                listOf("Tiên Hiệp", "Huyền Huyễn"),
            ),
        )

        recyclerItemModels.add(
            MyData(
                R.drawable.nguyenton,
                "Nguyên Tôn",
                "Thiên Tàm Thổ Đậu",
                1502,
                listOf("Tiên Hiệp", "Huyền Huyễn"),
            ),
        )

        recyclerItemModels.add(
            MyData(
                R.drawable.daichuate,
                "Vũ động càn khôn",
                "Thiên Tàm Thổ Đậu",
                1563,
                listOf("Tiên Hiệp", "Huyền Huyễn", "Dị Giới"),
            ),
        )

        recyclerItemModels.add(
            MyData(
                R.drawable.tamthe,
                "Tam thể",
                "Lưu Từ Hân",
                38,
                listOf("Khoa Học", "Viễn Tưởng"),
            ),
        )

        recyclerItemModels.add(
            MyData(
                R.drawable.thegioihoanmy,
                "Thế giới hoàn mỹ",
                "Thần Đông",
                2015,
                listOf("Tiên Hiệp", "Kiếm Hiệp", "Huyền Huyễn"),
            ),
        )

        recyclerItemModels.add(
            MyData(
                R.drawable.giathien,
                "Già Thiên",
                "Thần Đông",
                1896,
                listOf("Tiên Hiệp", "Dị Giới"),
            ),
        )

        recyclerItemModels.add(
            MyData(
                R.drawable.thanhkhu,
                "Thánh Khư",
                "Thần Đông",
                1670,
                listOf("Tiên Hiệp", "Huyền Huyễn"),
            ),
        )

        recyclerItemModels.add(
            MyData(
                R.drawable.quybichichu,
                "Quỷ Bí Chi Chủ",
                "Ái Tiềm Thủy Đích Ô Tặc",
                1412,
                listOf("Huyền Huyễn"),
            ),
        )

        recyclerItemModels.add(
            MyData(
                R.drawable.phamnhantutien,
                "Phàm Nhân tu tiên",
                "Vong Ngữ",
                2468,
                listOf("Tiên Hiệp", "Kiếm Hiệp"),
            ),
        )

        recyclerItemModels.add(
            MyData(
                R.drawable.phamnhantutientiengioithien,
                "Phàm Nhân tu tiên - Tiên Giới Thiên",
                "Vong Ngữ",
                1397,
                listOf("Tiên Hiệp", "Huyền Huyễn"),
            ),
        )

        recyclerItemModels.add(
            MyData(
                R.drawable.mucthanky,
                "Mục Thần ký",
                "Trạch Trư",
                1844,
                listOf("Huyền Huyễn", "Hài Hước", "Chính trị"),
            ),
        )

        recyclerItemModels.add(
            MyData(
                R.drawable.trutien,
                "Tru Tiên",
                "Tiêu Đỉnh",
                258,
                listOf("Tiên Hiệp", "Kiếm Hiệp"),
            ),
        )

        recyclerItemModels.add(
            MyData(
                R.drawable.tuyettrunghandaohanh,
                "Tuyết Trung Hãn Đao Hành",
                "Phong Hỏa Hí Chư Hầu",
                997,
                listOf("Huyền Huyễn", "Kiếm Hiệp"),
            ),
        )

        recyclerItemModels.add(
            MyData(
                R.drawable.kiemlai,
                "Kiếm Lai",
                "Phong Hỏa Hí Chư Hầu",
                997,
                listOf("Tiên Hiệp", "Kiếm Hiệp"),
            ),
        )

        recyclerItemModels.add(
            MyData(
                R.drawable.deba,
                "Đế Bá",
                "Yểm Bút Tiêu Sinh",
                7195,
                listOf("Huyền Huyễn"),
            ),
        )

        recyclerItemModels.add(
            MyData(
                R.drawable.nhatniemvinhhang,
                "Nhất niệm vĩnh hằng",
                "Nhĩ Căn",
                1981,
                listOf("Tiên Hiệp", "Huyền Huyễn"),
            ),
        )

        recyclerItemModels.add(
            MyData(
                R.drawable.cochannhan,
                "Cổ Chân Nhân",
                "Cổ Chân Nhân",
                2333,
                listOf("Tiên Hiệp", "Huyền Huyễn", "Xuyên Không"),
            ),
        )

        liveDataOfList.value = recyclerItemModels
    }
}
