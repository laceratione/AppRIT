package com.example.ritapp.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.ritapp.R
import com.squareup.picasso.Picasso

class ImageFragment(private val url: String): Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_image, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val image: ImageView = view.findViewById(R.id.image)
        image.setOnClickListener {
            activity?.onBackPressed()
        }

        Picasso.with(requireContext())
            .load(url)
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(image)

    }

}