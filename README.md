# ExRecyclerView

Ứng dụng này hiển thị danh sách các dữ liệu mẫu dưới dạng card view, bao gồm các thông tin như hình ảnh, tiêu đề, tác giả, số chương và thể loại.

## Tính năng

- **Hiển thị danh sách dữ liệu**: Sử dụng RecyclerView để hiển thị các mục dữ liệu với gồm 22 ảnh minh họa truyện, tên truyện, tác giả, số chương, thể loại được cho vào vòng lặp để tiếp tục sinh thêm dữ liệu.
- **Phân trang (Load More)**: Tự động tải thêm dữ liệu khi người dùng cuộn đến cuối danh sách.
- **Làm mới dữ liệu (Refresh)**: Cung cấp tính năng làm mới dữ liệu khi kéo xuống bằng SwipeRefreshLayout.
- **Dữ liệu ngẫu nhiên**: Dữ liệu hiển thị trong RecyclerView được làm mới và trộn ngẫu nhiên mỗi khi người dùng làm mới hoặc tải thêm dữ liệu.

## Cài đặt

### Cài đặt dự án

1. **Clone Repository**

    ```bash
    git clone https://github.com/kouhoang/ExRecyclerview.git
    ```

2. **Mở dự án bằng Android Studio**

    - Mở Android Studio và chọn "Open an Existing Project".
    - Chọn thư mục dự án bạn vừa clone.

3. **Cài đặt Dependencies**

    - Mở file `build.gradle` (Module: app) và thêm các dependencies cần thiết nếu chưa có.
    - Nhấn "Sync Now" để đồng bộ dự án với Gradle.

4. **Chạy ứng dụng**

    - Kết nối thiết bị Android hoặc sử dụng trình giả lập (emulator).
    - Nhấn "Run" trong Android Studio để biên dịch và chạy ứng dụng trên thiết bị.

## Cấu trúc dự án

- **Model**: Lớp `MyData` định nghĩa cấu trúc dữ liệu cho từng mục trong danh sách.
- **Adapter**: `MyAdapter` quản lý việc gán dữ liệu cho các item trong RecyclerView.
- **ViewModel**: `RecyclerViewViewModel` quản lý dữ liệu và logic phân trang, làm mới dữ liệu.
- **View**: `MainActivity` là activity chính chứa RecyclerView và SwipeRefreshLayout.

## Hướng dẫn sử dụng

1. **Chạy ứng dụng**: Sau khi chạy ứng dụng, bạn sẽ thấy danh sách các mục dữ liệu được hiển thị trong RecyclerView.
2. **Cuộn và tải thêm**: Khi cuộn đến cuối danh sách, dữ liệu mới sẽ tự động được tải thêm để trải nghiệm mượt mà hơn.
3. **Làm mới dữ liệu**: Kéo xuống để làm mới dữ liệu và thấy danh sách được cập nhật với dữ liệu ngẫu nhiên.

