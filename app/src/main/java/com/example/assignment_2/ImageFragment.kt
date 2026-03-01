package com.example.assignment_2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.assignment_2.R
import com.github.chrisbanes.photoview.PhotoView
import com.squareup.picasso.Picasso

class ImageFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view = inflater.inflate(R.layout.fragment_image, container, false)

        val photoView = view.findViewById<PhotoView>(R.id.photoView)

        Picasso.get()
            .load("https://picsum.photos/800")
            .into(photoView)

        return view
    }
}