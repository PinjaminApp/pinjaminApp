package com.md.pinjaminapp.ui.pinjamBarang

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.md.pinjaminapp.R
import de.hdodenhof.circleimageview.CircleImageView

class ReviewAdapter(private val reviews: List<Review>) : // <--- KONSTRUKTOR INI PENTING!
    RecyclerView.Adapter<ReviewAdapter.ReviewViewHolder>() {

    class ReviewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val reviewerProfilePic: CircleImageView = itemView.findViewById(R.id.reviewer_profile_pic)
        val reviewerName: TextView = itemView.findViewById(R.id.reviewer_name)
        val reviewRatingText: TextView = itemView.findViewById(R.id.review_rating_text)
        val reviewContent: TextView = itemView.findViewById(R.id.review_content)
        val reviewStarIcon: ImageView = itemView.findViewById(R.id.review_star_icon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_review, parent, false)
        return ReviewViewHolder(view)
    }

    override fun onBindViewHolder(holder: ReviewViewHolder, position: Int) {
        val review = reviews[position]

        holder.reviewerName.text = review.reviewerName
        holder.reviewRatingText.text = review.rating.toString()
        holder.reviewContent.text = review.content

        holder.reviewerProfilePic.setImageResource(review.reviewerProfilePicUrl)

        if (review.rating >= 1) {
            holder.reviewStarIcon.setImageResource(R.drawable.ic_star_filled)
            holder.reviewStarIcon.visibility = View.VISIBLE
        } else {
            holder.reviewStarIcon.visibility = View.GONE
        }
    }

    override fun getItemCount(): Int = reviews.size
}