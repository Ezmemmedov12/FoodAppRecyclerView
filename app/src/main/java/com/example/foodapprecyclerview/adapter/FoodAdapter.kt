package com.example.foodapprecyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapprecyclerview.Food
import com.example.foodapprecyclerview.databinding.FoodItemBinding
import com.example.foodapprecyclerview.model.FoodResponseItem
import com.example.foodapprecyclerview.model.Hint
import com.squareup.picasso.Picasso

class FoodAdapter: RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {
    val foodList= ArrayList<Food>()
    inner class FoodViewHolder(val binding: FoodItemBinding) :
        RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
      val layout=FoodItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
       return FoodViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return foodList.size
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val item= foodList[position]
        holder.binding.food=item
        Picasso.get().load(item.image).into(holder.binding.imageView)
    }

    fun updateList(list: List<Food>){
        foodList.clear()
        foodList.addAll(list)
        notifyDataSetChanged()
    }
}
