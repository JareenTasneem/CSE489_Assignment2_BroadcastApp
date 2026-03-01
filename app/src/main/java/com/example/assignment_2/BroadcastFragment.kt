package com.example.assignment_2

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.fragment.app.Fragment
import com.example.assignment_2.BatteryActivity
import com.example.assignment_2.CustomInputActivity
import com.example.assignment_2.R

class BroadcastFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view = inflater.inflate(R.layout.fragment_broadcast, container, false)

        val spinner = view.findViewById<Spinner>(R.id.spinnerBroadcast)
        val button = view.findViewById<Button>(R.id.buttonProceed)

        val options = arrayOf(
            "Custom broadcast receiver",
            "System battery notification receiver"
        )

        val adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_dropdown_item,
            options
        )

        spinner.adapter = adapter

        button.setOnClickListener {
            val selected = spinner.selectedItem.toString()

            if (selected == "Custom broadcast receiver") {
                val intent = Intent(requireContext(), CustomInputActivity::class.java)
                startActivity(intent)
            } else {
                val intent = Intent(requireContext(), BatteryActivity::class.java)
                startActivity(intent)
            }
        }

        return view
    }
}