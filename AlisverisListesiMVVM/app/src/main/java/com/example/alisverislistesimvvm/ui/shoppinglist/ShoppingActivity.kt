package com.example.alisverislistesimvvm.ui.shoppinglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.alisverislistesimvvm.R
import com.example.alisverislistesimvvm.database.ShoppingDatabase
import com.example.alisverislistesimvvm.data.ShoppingItem
import com.example.alisverislistesimvvm.adapter.ShoppingItemAdapter
import com.example.alisverislistesimvvm.repository.ShoppingRepository
import kotlinx.android.synthetic.main.activity_shopping.*

class ShoppingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)
        val database= ShoppingDatabase(this)
        val repository=ShoppingRepository(database)
        val factory= ShoppingViewModelFactory(repository)

        val viewModel= ViewModelProviders.of(this,factory).get(ShoppingViewModel::class.java)

        val adapter= ShoppingItemAdapter(listOf(),viewModel)

        shoppingItems.layoutManager=LinearLayoutManager(this)
        shoppingItems.adapter=adapter

        viewModel.getAllData().observe(this, Observer {
            adapter.items=it
            adapter.notifyDataSetChanged()
        })

        fab.setOnClickListener {
            AddShoppingItemDialog(this,object :onAddButtonClicked{
                override fun onAddButtonClicked(item: ShoppingItem) {
                    viewModel.upsert(item)
                }

            }).show()
        }
    }
}