package com.example.alisverislistesimvvm.repository

import com.example.alisverislistesimvvm.database.ShoppingDatabase
import com.example.alisverislistesimvvm.data.ShoppingItem

class ShoppingRepository(private val db: ShoppingDatabase) {

    suspend fun upsert(item: ShoppingItem)=db.shoppingDao().upsert(item)

    suspend fun delete(item: ShoppingItem)=db.shoppingDao().delete(item)

    fun getAllData()=db.shoppingDao().getAllShoppingItems()
}