package com.example.androidtaskem.TaskOne_Fragments.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.androidtaskem.R
import com.example.androidtaskem.TaskOne_Fragments.back
import com.example.androidtaskem.databinding.FragmentSecondBinding
import com.example.androidtaskem.TaskOne_Fragments.navigate

class SecondFragment : Fragment(R.layout.fragment_second) {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        navigateToThirdScreen()
        navigateToBackScreen()
        return binding.root
    }

    private fun navigateToThirdScreen() {
        binding.nextBtn.setOnClickListener {
            navigate(ThirdFragment())
        }
    }

    private fun navigateToBackScreen() {
        binding.previousBtn.setOnClickListener {
            this.back()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
