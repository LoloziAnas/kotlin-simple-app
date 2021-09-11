package com.lzitech.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lzitech.myapplication.adapters.ItemAdapter
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private val listOfItems = generateDummyList(100)
    private val adapter = ItemAdapter(listOfItems as MutableList<Item>)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerViewMain = findViewById<RecyclerView>(R.id.rv_main)
        recyclerViewMain.adapter = adapter
        recyclerViewMain.layoutManager = LinearLayoutManager(this)
        recyclerViewMain.setHasFixedSize(true)
    }

    private fun generateDummyList(size: Int): ArrayList<Item> {
        val items = ArrayList<Item>()
        for (i in 0 until size) {
            val drl = when (i % 3) {
                0 -> R.drawable.ic_account
                1 -> R.drawable.ic_device
                else -> R.drawable.ic_run
            }
            val item = Item(drl, "item $i", "Line $i")
            items.add(item)
        }
        return items
    }

    fun insert(view: View) {
        val index = Random.nextInt(8)
        val insertedItem = Item(
            R.drawable.ic_device,"inserted item $index","Line $index"
        )
        listOfItems.add(index, insertedItem)
        adapter.notifyItemInserted(index)

    }
    fun delete(view: View) {
        val index = Random.nextInt(8)

        listOfItems.removeAt(index)
        Toast.makeText(this,"Item index $index removed",Toast.LENGTH_LONG).show()
        adapter.notifyItemRemoved(index)
    }
}