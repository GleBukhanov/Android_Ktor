package com.example.android5.presentation

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android5.data.ApiResponse
import com.example.android5.databinding.ListItemBinding


class ApiResponseAdapter(private var items: List<ApiResponse>) :
    RecyclerView.Adapter<ApiResponseAdapter.ApiResponseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ApiResponseViewHolder {
        val binding =
            ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ApiResponseViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ApiResponseViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    @SuppressLint("NotifyDataSetChanged")
    fun setData(newData: List<ApiResponse>) {
        this.items = newData
        notifyDataSetChanged()
    }

    class ApiResponseViewHolder(private val binding: ListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(apiResponse: ApiResponse) {
            with(binding) {
                nameTextView.text = apiResponse.name ?: "-"
                cultureTextView.text = apiResponse.culture ?: "-"
                bornTextView.text = (apiResponse.born ?: "-").toString()
                titlesTextView.text = (apiResponse.titles.joinToString(", "))
                aliasesTextView.text = (apiResponse.aliases.joinToString(", "))
                playedByTextView.text = (apiResponse.playedBy.joinToString(", "))
            }
        }
    }
}
