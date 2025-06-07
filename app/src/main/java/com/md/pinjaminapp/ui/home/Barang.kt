package com.md.pinjaminapp.ui.home

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Barang(
    val nama: String,
    val gambar: Int,
    val alamat: String,
    val jarak: String,
    val harga: String
):Parcelable
