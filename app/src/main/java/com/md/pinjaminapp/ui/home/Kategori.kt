package com.md.pinjaminapp.ui.home

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Kategori(
    val nama: String,
    val gambar: Int
):Parcelable
