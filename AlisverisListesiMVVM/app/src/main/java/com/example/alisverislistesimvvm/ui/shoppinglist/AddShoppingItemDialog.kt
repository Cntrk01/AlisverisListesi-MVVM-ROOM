package com.example.alisverislistesimvvm.ui.shoppinglist

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.example.alisverislistesimvvm.R
import com.example.alisverislistesimvvm.data.ShoppingItem
import kotlinx.android.synthetic.main.add_shopping_item.*

class AddShoppingItemDialog(context: Context,var addDialogListener:onAddButtonClicked):AppCompatDialog(context) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_shopping_item)

        tvAdd.setOnClickListener {
            val name=etName.text.toString()
            val amount=etAmount.text.toString()
            if(name.isEmpty() ||amount.isEmpty()){
                Toast.makeText(context,"Boş Yerleri Doldurunuz",Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            val item= ShoppingItem(name,amount.toInt())
            addDialogListener.onAddButtonClicked(item)
            dismiss()
        }
        tvCancel.setOnClickListener {
            cancel()
        }
    }
}