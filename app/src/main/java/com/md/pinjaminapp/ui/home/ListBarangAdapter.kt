package com.md.pinjaminapp.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.md.pinjaminapp.R
import com.md.pinjaminapp.ui.home.ListKategoriAdapter.ListViewHolder

class ListBarangAdapter (private val listBarang: ArrayList<Barang>): RecyclerView.Adapter<ListBarangAdapter.ListViewHolder>() {

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imgBarang: ImageView = itemView.findViewById(R.id.img_barang)
        val textNamaBarang: TextView = itemView.findViewById(R.id.text_nama_barang)
        val textAlamat: TextView = itemView.findViewById(R.id.text_alamat)
        val textJarak: TextView = itemView.findViewById(R.id.text_jarak)
        val textHarga: TextView = itemView.findViewById(R.id.text_harga)

    }
    override fun getItemCount(): Int {
        return listBarang.size
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_barang, parent, false)
        return com.md.pinjaminapp.ui.home.ListBarangAdapter.ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListBarangAdapter.ListViewHolder, position: Int) {
        val (nama, gambar, alamat, jarak, harga) = listBarang[position]
        holder.imgBarang.setImageResource(gambar)
        holder.textNamaBarang.text = nama
        holder.textAlamat.text = alamat
        holder.textJarak.text = jarak
        holder.textHarga.text = harga


    }
}
