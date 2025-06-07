package com.md.pinjaminapp.ui.sewakanBarang

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.md.pinjaminapp.R
import com.md.pinjaminapp.databinding.FragmentSewakanbarangBinding

class SewakanBarangFragment : Fragment() {

    private var _binding: FragmentSewakanbarangBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: SewakanBarangAdapter
    private val listBarang = ArrayList<SewakanBarang>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSewakanbarangBinding.inflate(inflater, container, false)

        setupRecyclerView()
        loadDummyData()

        return binding.root
    }

    private fun setupRecyclerView() {
        adapter = SewakanBarangAdapter(listBarang)
        binding.rvSewakanbarang.layoutManager = LinearLayoutManager(requireContext())
        binding.rvSewakanbarang.adapter = adapter
    }

    private fun loadDummyData() {
        listBarang.add(
            SewakanBarang(
                namaBarang = "Air fryer",
                gambar = R.drawable.airfryer, // pastikan gambar ini ada di drawable
                status = "Tersedia",
                harga = "Rp 10.000/hari",
                jumlahPenyewa = "200",
                rating = "4.8",
                review = "(131 reviews)"
            )
        )
        // Tambahkan data lain jika perlu
        adapter.notifyDataSetChanged()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
