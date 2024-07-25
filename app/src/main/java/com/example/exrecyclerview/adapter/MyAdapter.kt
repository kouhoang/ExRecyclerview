package com.example.exrecyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.exrecyclerview.R
import com.example.exrecyclerview.model.MyData

class MyAdapter(
    private var data: List<MyData>,
) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    // ViewHolder để giữ các tham chiếu đến các view trong layout item
    inner class MyViewHolder(
        itemView: View,
    ) : RecyclerView.ViewHolder(itemView) {
        val imageView = itemView.findViewById<ImageView>(R.id.imageView)
        val tenTruyen = itemView.findViewById<TextView>(R.id.tenTruyen)
        val tacGia = itemView.findViewById<TextView>(R.id.tacGia)
        val soChuong = itemView.findViewById<TextView>(R.id.soChuong)
        val theLoaiContainer = itemView.findViewById<LinearLayout>(R.id.theLoaiContainer)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): MyViewHolder {
        val view =
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.recycler_view_design, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: MyViewHolder,
        position: Int,
    ) {
        val item = data[position]
        holder.imageView.setImageResource(item.imageResId)
        holder.tenTruyen.text = item.title
        holder.tacGia.text = item.author
        holder.soChuong.text = "${item.chapterCount} chương"

        holder.theLoaiContainer.removeAllViews()
        item.genres.forEach { genre ->
            val textView = TextView(holder.itemView.context)
            textView.text = genre
            textView.setPadding(8, 4, 8, 4)
            textView.background = holder.itemView.context.getDrawable(R.drawable.bg_genre) // Optional
            holder.theLoaiContainer.addView(textView)
        }
    }

    override fun getItemCount(): Int = data.size

    // Cập nhật dữ liệu và thông báo cho RecyclerView để làm mới hiển thị
    fun updateData(newData: List<MyData>) {
        data = newData
        notifyDataSetChanged()
    }
}
