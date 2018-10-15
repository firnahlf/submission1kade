package com.example.firna.submission1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.firna.submission1.R.array.*
import com.example.firna.submission1.R.layout.activity_main
import kotlinx.android.synthetic.main.activity_main.*


import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    private var items: MutableList<item> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_main)
        initData()

        rmhadat_list.layoutManager = LinearLayoutManager(this)
        rmhadat_list.adapter = RecyclerViewAdapter(this, items){itemClicked(it)}
    }

    private fun initData(){
        val name = resources.getStringArray(rmhadat_name)
        val image = resources.obtainTypedArray(rmhadat_image)
        val description = resources.getStringArray(rmhadat_description)
        items.clear()
        for (i in name.indices) {
            items.add(item(name[i],
                    image.getResourceId(i, 0), description[i]))
        }

        //Recycle the typed array
        image.recycle()
    }
    private fun itemClicked(items: item){
        startActivity<DetailActivity>(DetailActivity.JUDUL to items.name, DetailActivity.GAMBAR to items.image, DetailActivity.DESKRIPSI to items.description)
    }
}