package com.md.pinjaminapp.ui.home

import android.graphics.Rect
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.md.pinjaminapp.R
import com.md.pinjaminapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var listKategoriAdapter: ListKategoriAdapter
    private lateinit var listBarangAdapter: ListBarangAdapter
    private lateinit var listRekomendasiAdapter: ListBarangAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as AppCompatActivity).supportActionBar?.hide()

        // Dummy data kategori
        val dummyKategori = arrayListOf(
            Kategori("Elektronik", R.drawable.elektronik),
            Kategori("Alat Rumah", R.drawable.alatrumah),
            Kategori("Olahraga", R.drawable.hobi),
            Kategori("Pertukangan", R.drawable.petukangan)
        )

        // Dummy data barang
        val dummyBarang = arrayListOf(
            Barang("Air Fryer", R.drawable.airfryer, "Jl. Kenanga No. 12", "2 km", "Rp 50.000/hari"),
            Barang("Air Fryer", R.drawable.airfryer, "Jl. Kenanga No. 12", "2 km", "Rp 50.000/hari"),
            )

        // Setup adapter
        listKategoriAdapter = ListKategoriAdapter(dummyKategori)
        listBarangAdapter = ListBarangAdapter(dummyBarang)
        listRekomendasiAdapter = ListBarangAdapter(dummyBarang) // contoh, bisa diganti data rekomendasi asli

        val spacingInPixels = resources.getDimensionPixelSize(R.dimen.recycler_item_spacing)
        // Setup RecyclerView kategori (horizontal)
        binding.rvKategori.apply {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = listKategoriAdapter
            setHasFixedSize(true)

            // Tambahkan gap antar item
            addItemDecoration(object : RecyclerView.ItemDecoration() {
                override fun getItemOffsets(
                    outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State
                ) {
                    val position = parent.getChildAdapterPosition(view)
                    val itemCount = state.itemCount

                    outRect.right = spacingInPixels

                    if (position == 0) {
                        outRect.left = spacingInPixels
                    }
                    if (position == itemCount - 1) {
                        outRect.right = spacingInPixels
                    }
                }
            })
        }

        // Setup RecyclerView barang sekitar (horizontal)
        binding.rvBarang.apply {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = listBarangAdapter
            setHasFixedSize(true)
        }

        // Setup RecyclerView rekomendasi (horizontal)
        binding.rvRekomendasi.apply {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = listRekomendasiAdapter
            setHasFixedSize(true)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
