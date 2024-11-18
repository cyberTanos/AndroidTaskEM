package com.example.androidtaskem.TaskOne_Fragments.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.androidtaskem.R
import com.example.androidtaskem.TaskOne_Fragments.back
import com.example.androidtaskem.databinding.FragmentFirstBinding
import com.example.androidtaskem.TaskOne_Fragments.navigate

class FirstFragment : Fragment(R.layout.fragment_first) {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        navigateToSecondScreen()
        navigateToBack()
        return binding.root
    }

    private fun navigateToSecondScreen() {
        binding.nextBtn.setOnClickListener {
            navigate(SecondFragment())
        }
    }

    private fun navigateToBack() {
        binding.previousBtn.setOnClickListener {
            back()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
