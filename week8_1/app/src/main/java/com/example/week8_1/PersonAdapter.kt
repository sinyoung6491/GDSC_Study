package com.example.week8_1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.week8_1.databinding.PersonItemBinding

class PersonAdapter : RecyclerView.Adapter<PersonAdapter.ViewHolder>() {
    var items = ArrayList<Person>()

    lateinit var listener:OnPersonItemClickListener

    override fun getItemCount() = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(PersonItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.setItem(item)
    }

    inner class ViewHolder(val binding: PersonItemBinding):RecyclerView.ViewHolder(binding.root){

        init{
            binding.root.setOnClickListener{
                listener?.onItemClick(this,binding.root,adapterPosition)
            }
        }
        fun setItem(item:Person){
            binding.output1.text = item.name
            binding.output2.text = item.mobile
        }
    }
}