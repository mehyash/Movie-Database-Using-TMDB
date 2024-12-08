package com.yash.imdbclone.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.yash.imdbclone.R
import com.yash.imdbclone.data.Result
class MovieAdapter(private val list:List<Result>):RecyclerView.Adapter<MovieAdapter.MovieviewHolder>() {
    inner class MovieviewHolder(itemview: View):ViewHolder(itemview){
        val title=itemview.findViewById<TextView>(R.id.title)
        val review=itemview.findViewById<TextView>(R.id.review)
        val rating=itemview.findViewById<TextView>(R.id.rating)
        val daterelease=itemview.findViewById<TextView>(R.id.daterelease)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieviewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.cardview,parent,false)
        return MovieviewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MovieviewHolder, position: Int) {
        val current=list[position]
        holder.title.text=current.title.toString()
        holder.review.text=current.overview
        holder.daterelease.text=current.release_date.toString()
        holder.rating.text=current.vote_average.toString()
    }
}