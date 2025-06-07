package com.md.pinjaminapp.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.md.pinjaminapp.R

class ListKategoriAdapter (private val listKategori: ArrayList<Kategori>): RecyclerView.Adapter<ListKategoriAdapter.ListViewHolder>(){

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgKategori: ImageView = itemView.findViewById(R.id.img_kategori)
        val textKategori: TextView = itemView.findViewById(R.id.text_kategori)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_kategori, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListKategoriAdapter.ListViewHolder, position: Int) {
        val (nama, gambar) = listKategori[position]
        holder.imgKategori.setImageResource(gambar)
        holder.textKategori.text = nama
//        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listKategori[holder.adapterPosition]) }
    }

    override fun getItemCount(): Int {
        return listKategori.size
    }
}