package com.example.memestream.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.memestream.R
import com.example.memestream.data.model.Meme

class MemeAdapter(private var memes: List<Meme>) : RecyclerView.Adapter<MemeAdapter.MemeViewHolder>() {

    class MemeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val memeImage: ImageView = itemView.findViewById(R.id.memeImage)
        val memeTitle: TextView = itemView.findViewById(R.id.memeTitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_meme, parent, false)
        return MemeViewHolder(view)
    }

    override fun onBindViewHolder(holder: MemeViewHolder, position: Int) {
        val meme = memes[position]
        holder.memeTitle.text = meme.title ?: "Untitled"
        Glide.with(holder.itemView.context)
            .load(meme.url)
            .centerCrop()
            .into(holder.memeImage)
    }

    override fun getItemCount(): Int = memes.size

    fun updateMemes(newMemes: List<Meme>) {
        memes = newMemes
        notifyDataSetChanged()
    }
}
