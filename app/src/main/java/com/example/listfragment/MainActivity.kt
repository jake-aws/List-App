package com.example.listfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listfragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val itemList = mutableListOf<Item>(
            Item("Do Recycler Views", false ),
            Item("Do Fragments", false ),
            Item("Do drink coffee", false ),
            Item("Live, Love, Laugh", false ),
        )

        val adapter = RViewAdapter(itemList)
        binding.rvRecycleView.adapter = adapter
        binding.rvRecycleView.layoutManager = LinearLayoutManager(this)

        binding.btnButton.setOnClickListener{
            val title:String = binding.etEditText.text.toString()
            val item = Item(title,false)
            itemList.add(item)
            adapter.notifyItemInserted(itemList.size - 1)
            binding.etEditText.text.clear()

        }


    }

}