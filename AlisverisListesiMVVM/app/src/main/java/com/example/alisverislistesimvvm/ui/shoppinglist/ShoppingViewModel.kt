package com.example.alisverislistesimvvm.ui.shoppinglist

import androidx.lifecycle.ViewModel
import com.example.alisverislistesimvvm.data.ShoppingItem
import com.example.alisverislistesimvvm.repository.ShoppingRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ShoppingViewModel(private val repository: ShoppingRepository):ViewModel() {

    fun upsert(item: ShoppingItem)=GlobalScope.launch(Dispatchers.IO) {
        repository.upsert(item)
    }
    fun delete(item: ShoppingItem)= GlobalScope.launch(Dispatchers.IO){
        repository.delete(item)
    }
    fun getAllData()=repository.getAllData()
}
