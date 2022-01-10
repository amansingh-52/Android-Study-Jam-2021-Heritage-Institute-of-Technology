package com.example.classroutine.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.classroutine.databinding.ClassItemBinding
import com.example.classroutine.db.ClassEntry

class ClassAdapter(val context: Context, var list: List<ClassEntry>) :
    RecyclerView.Adapter<ClassAdapter.ClassVH>() {

    inner class ClassVH(val binding: ClassItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(position: Int) {
            val currItem = list[position]
            binding.title.text = currItem.subject
            binding.details.text =
                "${currItem.day} ${currItem.time} ${currItem.teacher}\n\n${currItem.link}"
            binding.card.setOnLongClickListener {
                (context as OnClickItem).delete(currItem)
                true
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClassVH = ClassVH(
        ClassItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ClassVH, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = list.size

    interface OnClickItem {
        fun delete(classEntry: ClassEntry)
    }

    fun updateViews(updatedList: List<ClassEntry>) {
        list = updatedList
        notifyDataSetChanged()
    }
}