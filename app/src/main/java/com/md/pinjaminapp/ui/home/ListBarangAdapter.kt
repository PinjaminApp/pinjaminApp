package com.md.pinjaminapp.ui.home // Sesuaikan dengan package adapter Anda

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.md.pinjaminapp.R

class ListBarangAdapter(
    private val listBarang: ArrayList<Barang>,
    private val listener: OnItemClickListener
) : RecyclerView.Adapter<ListBarangAdapter.ListViewHolder>() {

    // 1. Definisi interface click listener
    interface OnItemClickListener {
        fun onItemClick(barang: Barang)
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgBarang: ImageView = itemView.findViewById(R.id.img_barang)
        val textNamaBarang: TextView = itemView.findViewById(R.id.text_nama_barang)
        val textAlamat: TextView = itemView.findViewById(R.id.text_alamat)
        val textJarak: TextView = itemView.findViewById(R.id.text_jarak)
        val textHarga: TextView = itemView.findViewById(R.id.text_harga)

        init {
            // 3. Set OnClickListener pada root view item
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    listener.onItemClick(listBarang[position]) // Panggil listener dengan data barang
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_barang, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val barang = listBarang[position]
        holder.imgBarang.setImageResource(barang.gambar)
        holder.textNamaBarang.text = barang.nama
        holder.textAlamat.text = barang.alamat
        holder.textJarak.text = barang.jarak
        holder.textHarga.text = barang.harga
    }

    override fun getItemCount(): Int = listBarang.size
}