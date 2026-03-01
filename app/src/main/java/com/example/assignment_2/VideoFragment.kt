package com.example.assignment_2

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.VideoView
import androidx.fragment.app.Fragment
import com.example.assignment_2.R

class VideoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view = inflater.inflate(R.layout.fragment_video, container, false)

        val videoView = view.findViewById<VideoView>(R.id.videoView)

        val uri = Uri.parse(
            "android.resource://" + requireContext().packageName + "/" + R.raw.sample
        )

        videoView.setVideoURI(uri)

        // Add built-in controller
        val mediaController = android.widget.MediaController(requireContext())
        mediaController.setAnchorView(videoView)
        videoView.setMediaController(mediaController)

        videoView.start()

        return view
    }
}