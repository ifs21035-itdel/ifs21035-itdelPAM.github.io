package com.ifs21035.duplikataplikasi

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ifs21035.duplikataplikasi.databinding.ItemRowPeopleBinding

class ListPeopleAdapter(private val listPeople: ArrayList<People>) :
    RecyclerView.Adapter<ListPeopleAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemRowPeopleBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ListViewHolder(binding)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val people = listPeople[position]
        holder.binding.ivItemPeople.setImageResource(people.icon)
        holder.binding.tvItemName.text = people.name
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listPeople[holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int = listPeople.size

    class ListViewHolder(var binding: ItemRowPeopleBinding) : RecyclerView.ViewHolder(binding.root)

    interface OnItemClickCallback {
        fun onItemClicked(data: People)
    }
}