package com.example.alisverislistesimvvm.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.alisverislistesimvvm.data.ShoppingItem

@Dao
interface ShoppingDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun upsert(item: ShoppingItem)

    @Delete
     fun delete(item: ShoppingItem)

    @Query("SELECT*FROM  shopping_items")
    fun getAllShoppingItems():LiveData<List<ShoppingItem>>
}