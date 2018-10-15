package com.example.firna.submission1


import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.firna.submission1.R.id.image
import com.example.firna.submission1.R.id.name
import com.example.firna.submission1.R.layout.item_list
import kotlinx.android.extensions.LayoutContainer


class RecyclerViewAdapter(private val context: Context, private val items: List<item>, private val listener: (item) -> Unit)
    : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position], listener)
    }

    override fun getItemCount(): Int = items.size



    class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
            LayoutContainer{
        val name: TextView = containerView.findViewById(R.id.name)
        val image: ImageView = containerView.findViewById(R.id.image)

        fun bindItem(items: item, listener: (item) -> Unit) {
            name.text = items.name
            Glide.with(containerView).load(items.image).into(image)
            containerView.setOnClickListener { listener(items) }
        }
    }
}


