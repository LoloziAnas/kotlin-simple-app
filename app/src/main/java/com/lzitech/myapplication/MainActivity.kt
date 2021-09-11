package com.lzitech.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lzitech.myapplication.adapters.ItemAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val listOfItems = generateDummyList(100)
        val recyclerViewMain = findViewById<RecyclerView>(R.id.rv_main)
        recyclerViewMain.adapter = ItemAdapter(listOfItems as MutableList<Item>)
        recyclerViewMain.layoutManager = LinearLayoutManager(this)
        recyclerViewMain.setHasFixedSize(true)
    }

    private fun generateDummyList(size: Int): List<Item> {
        val items = ArrayList<Item>()
        for (i in 0 until size) {
            val drl = when (i % 3) {
                0 -> R.drawable.ic_account
                1 -> R.drawable.ic_android
                else -> R.drawable.ic_run
            }
            val item = Item(drl, "item $i", "Line $i")
            items.add(item)
        }

        return items
    }
}