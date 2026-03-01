package com.example.assignment_2

import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.SeekBar
import androidx.fragment.app.Fragment

class AudioFragment : Fragment() {

    private var mediaPlayer: MediaPlayer? = null
    private lateinit var seekBar: SeekBar
    private val handler = Handler(Looper.getMainLooper())

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view = inflater.inflate(R.layout.fragment_audio, container, false)

        val buttonPlay = view.findViewById<Button>(R.id.buttonPlay)
        seekBar = view.findViewById(R.id.seekBar)

        mediaPlayer = MediaPlayer.create(requireContext(), R.raw.audio)

        buttonPlay.setOnClickListener {
            mediaPlayer?.start()
            seekBar.max = mediaPlayer!!.duration
            updateSeekBar()
        }

        seekBar.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {

            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    mediaPlayer?.seekTo(progress)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        return view
    }

    private fun updateSeekBar() {
        seekBar.progress = mediaPlayer!!.currentPosition
        if (mediaPlayer!!.isPlaying) {
            handler.postDelayed({ updateSeekBar() }, 500)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release()
    }
}