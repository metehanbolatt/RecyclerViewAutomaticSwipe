package com.metehanbolat.recyclerviewautomaticswipeanimation

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.metehanbolat.recyclerviewautomaticswipeanimation.databinding.ItemOnBoardBinding

class ItemAdapter(val itemList: List<Item>): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(var binding: ItemOnBoardBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ItemOnBoardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = itemList[position]
        holder.binding.apply {
            image.setImageResource(item.image)
            textView.text = item.text
            itemLayout.setOnClickListener {
                Toast.makeText(holder.binding.root.context, item.text, Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun getItemCount() = itemList.size
}