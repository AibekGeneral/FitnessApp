package com.example.fitnessapp.ui.news

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fitnessapp.R
import kotlinx.android.synthetic.main.item_news.view.*

class NewsAdapter(var cards: List<String>, private val listener: OnAddressClickListener) :
    RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val root = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_news, parent, false)
        return NewsViewHolder(root)
    }

    override fun getItemCount(): Int {
        return cards.size
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(cards[position])
        val address = cards[position]
        holder.itemView.setOnClickListener {
            listener.onAddressClick(address.length)
        }
    }

    class NewsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name = view.tv_title
        fun bind(bankingCard: String) {
            name.text = bankingCard

        }
    }
}