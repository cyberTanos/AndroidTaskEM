package com.example.androidtaskem.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.androidtaskem.R
import com.example.androidtaskem.back
import com.example.androidtaskem.databinding.FragmentThirdBinding

class ThirdFragment : Fragment(R.layout.fragment_third) {

    private var _binding: FragmentThirdBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentThirdBinding.inflate(inflater, container, false)
        navigateToBackScreen()
        return binding.root
    }

    private fun navigateToBackScreen() {
        binding.previousBtn.setOnClickListener {
            back()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
