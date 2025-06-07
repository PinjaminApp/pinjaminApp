package com.md.pinjaminapp.ui.sewakanBarang

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SewakanBarang(
    val namaBarang: String,
    val gambar: Int,
    val status: String,
    val harga: String,
    val jumlahPenyewa: String,
    val rating: String,
    val review: String
): Parcelable
