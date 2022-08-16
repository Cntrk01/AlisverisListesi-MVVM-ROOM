package com.example.alisverislistesimvvm.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.alisverislistesimvvm.R
import com.example.alisverislistesimvvm.data.ShoppingItem
import com.example.alisverislistesimvvm.ui.shoppinglist.ShoppingViewModel
import kotlinx.android.synthetic.main.shopping_item.view.*

class ShoppingItemAdapter(var items:List<ShoppingItem>, private val viewModel: ShoppingViewModel):
    RecyclerView.Adapter<ShoppingItemAdapter.ShoppingViewHolder>() {

    inner class  ShoppingViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.shopping_item,parent,false)
        return ShoppingViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        var curShopItem=items.get(position)
        holder.itemView.tvName.text=curShopItem.name
        holder.itemView.tvAmount.text="${curShopItem.amount}"
        holder.itemView.ivDelete.setOnClickListener {
             viewModel.delete(curShopItem)
        }
        holder.itemView.ivPlus.setOnClickListener {
            curShopItem.amount++
            viewModel.upsert(curShopItem)
        }
        holder.itemView.ivMinus.setOnClickListener {
            if(curShopItem.amount>0){
                curShopItem.amount--
                viewModel.upsert(curShopItem)
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

}