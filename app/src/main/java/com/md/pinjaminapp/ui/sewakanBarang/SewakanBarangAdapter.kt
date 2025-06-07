package com.md.pinjaminapp.ui.sewakanBarang

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.md.pinjaminapp.R

class SewakanBarangAdapter(private val listSewakanBarang: ArrayList<SewakanBarang>) : RecyclerView.Adapter<SewakanBarangAdapter.ListViewHolder>() {
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val  textNamaBarang: TextView = itemView.findViewById(R.id.text_nama_barang)
        val  textStatus: TextView = itemView.findViewById(R.id.textAvailable)
        val  textHarga: TextView = itemView.findViewById(R.id.textPrice)
        val  textJumlahPenyewa: TextView = itemView.findViewById(R.id.text_jumlah_penyewa)
        val  textRating: TextView = itemView.findViewById(R.id.text_rating)
        val  textReview: TextView = itemView.findViewById(R.id.text_review)
        val  imgBarang: ImageView = itemView.findViewById(R.id.imageProduct)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_sewakan_barang, parent, false)
        return com.md.pinjaminapp.ui.sewakanBarang.SewakanBarangAdapter.ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: SewakanBarangAdapter.ListViewHolder, position: Int) {

        val (namaBarang, gambar, status, harga, jumlahPenyewa, rating, review ) = listSewakanBarang[position]
        holder.textNamaBarang.text = namaBarang
        holder.textStatus.text = status
        holder.textHarga.text = harga
        holder.textJumlahPenyewa.text = jumlahPenyewa
        holder.textRating.text = rating
        holder.textReview.text = review
        holder.imgBarang.setImageResource(gambar)
    }

    override fun getItemCount(): Int {
        return listSewakanBarang.size
    }

}