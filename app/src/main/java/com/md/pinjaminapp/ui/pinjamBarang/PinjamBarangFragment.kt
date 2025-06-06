package com.md.pinjaminapp.ui.pinjamBarang

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.md.pinjaminapp.R

class PinjamBarangFragment : Fragment() {

    companion object {
        fun newInstance() = PinjamBarangFragment()
    }

    private val viewModel: PinjamBarangViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_pinjam_barang, container, false)
    }
}