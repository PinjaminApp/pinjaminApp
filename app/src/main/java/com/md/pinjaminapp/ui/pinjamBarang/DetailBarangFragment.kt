package com.md.pinjaminapp.ui.pinjamBarang // Sesuaikan dengan package Anda

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.md.pinjaminapp.R
import com.md.pinjaminapp.databinding.FragmentDetailBarangBinding

// Data class untuk produk
data class ProductDetail(
    val name: String,
    val pricePerDay: String,
    val rating: Double,
    val totalReviews: Int,
    val ownerName: String,
    val ownerLocation: String,
    val ownerDistance: String,
    val description: String,
    val imageUrl: Int, // Untuk resource drawable lokal
    val ownerProfilePicUrl: Int // Untuk resource drawable lokal
)

// Data class untuk ulasan (sama seperti sebelumnya)
data class Review(
    val reviewerName: String,
    val rating: Int,
    val content: String,
    val reviewerProfilePicUrl: Int
)

class DetailBarangFragment : Fragment() {

    private var _binding: FragmentDetailBarangBinding? = null
    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBarangBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 1. Dummy Data for Product
        val dummyProduct = ProductDetail(
            name = "Air Fryer",
            pricePerDay = "Rp 10.000 /hari",
            rating = 4.8,
            totalReviews = 131,
            ownerName = "Ferdiansyah",
            ownerLocation = "Seukasari, Ciputat",
            ownerDistance = "Jarak 500m",
            description = "Air fryers cook food using hot air circulation, providing a healthier alternative to traditional frying by reducing oil consumption. Ideal for crispy, delicious meals with ease.",
            imageUrl = R.drawable.airfryer, // Pastikan Anda memiliki drawable ini
            ownerProfilePicUrl = R.drawable.pp_1 // Pastikan Anda memiliki drawable ini
        )

        // 2. Dummy Data for Reviews
        val dummyReviews = listOf(
            Review("Alvy Xavier", 5, "“I recently had the pleasure of staying at Jimbaran Resort Beach, and I must say it exceeded all my expectations. I will back soon!”", R.drawable.pp_1),
            Review("Budi Santoso", 4, "“Produk bagus dan sesuai deskripsi. Pelayanan pemilik juga ramah.”", R.drawable.pp_2),
            Review("Citra Dewi", 5, "“Sangat membantu untuk membuat makanan sehat, recommended!”", R.drawable.pp_3)
        )

        // 3. Populate Product Details
        with(binding) {
            productTitle.text = dummyProduct.name
            productPricePerDay.text = dummyProduct.pricePerDay
            ratingText.text = dummyProduct.rating.toString()
            reviewsCount.text = "(${dummyProduct.totalReviews} reviews)"
            ownerName.text = dummyProduct.ownerName
            ownerLocation.text = dummyProduct.ownerLocation
            ownerDistance.text = dummyProduct.ownerDistance
            productDescription.text = dummyProduct.description

            productImage.setImageResource(dummyProduct.imageUrl)
            ownerProfilePic.setImageResource(dummyProduct.ownerProfilePicUrl)

            // Setup the reviews RecyclerView
            reviewsRecyclerView.layoutManager = LinearLayoutManager(context)
            val reviewAdapter = ReviewAdapter(dummyReviews)
            reviewsRecyclerView.adapter = reviewAdapter

            // Populate bottom bar price
            bottomPrice.text = dummyProduct.pricePerDay

            favoriteButton.setOnClickListener {
                // Implement favorite functionality
                // Toast.makeText(context, "Favorite clicked!", Toast.LENGTH_SHORT).show()
            }
            chatButton.setOnClickListener {
                // Implement chat functionality
                // Toast.makeText(context, "Chat clicked!", Toast.LENGTH_SHORT).show()
            }
            seeAllReviewsButton.setOnClickListener {
                // Implement navigation to all reviews screen
                // Toast.makeText(context, "See all reviews clicked!", Toast.LENGTH_SHORT).show()
            }
            rentButton.setOnClickListener {
                // Implement rent action
                // Toast.makeText(context, "Sewa button clicked!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null // Clear binding when view is destroyed
    }
}