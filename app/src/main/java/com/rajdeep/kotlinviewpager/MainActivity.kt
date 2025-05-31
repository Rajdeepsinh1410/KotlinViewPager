package com.rajdeep.kotlinviewpager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {
    private lateinit var viewPager: ViewPager2
    private lateinit var pagerAdapter: ViewPagerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        viewPager = findViewById(R.id.viewPager)
        pagerAdapter = ViewPagerAdapter()
        viewPager.adapter = pagerAdapter
    }
    class ViewPagerAdapter : RecyclerView.Adapter<ViewHolder>(){
        private val itemList = listOf("Page1", "Page2", "Page3")
        override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
            return ViewHolder(view)
        }
        override fun onBindViewHolder(holder: ViewHolder,position: Int) {
            val item = itemList[position]
            holder.bind(item)
        }
        override fun getItemCount(): Int {
            return itemList.size
        }
    }
    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val textView : TextView =  itemView.findViewById<TextView>(R.id.pagertext)
        fun bind(item : String){
            textView.text = item
        }
    }
}