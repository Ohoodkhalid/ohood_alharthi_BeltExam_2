package com.example.ohood_alharthi_beltexam_2

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class HomeFragment : Fragment() {
    lateinit var browseAPIButton: Button
    lateinit var localDbButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_home, container, false)

        browseAPIButton = view.findViewById(R.id.browseAPIButton)
        localDbButton = view.findViewById(R.id.localDbButton)

        browseAPIButton.setOnClickListener{
         findNavController().navigate(R.id.action_homeFragment_to_searchFragment)
     }
        localDbButton.setOnClickListener{
            findNavController().navigate(R.id.action_homeFragment_to_localDBFragment)
        }

        return view
    }


}