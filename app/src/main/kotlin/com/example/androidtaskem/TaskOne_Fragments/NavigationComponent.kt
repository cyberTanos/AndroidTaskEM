package com.example.androidtaskem.TaskOne_Fragments

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.androidtaskem.R

fun AppCompatActivity.setStartScreen(fragment: Fragment) {
    supportFragmentManager
        .beginTransaction()
        .add(R.id.fragmentContainer, fragment)
        .commit()
}

fun Fragment.navigate(fragment: Fragment) {
    parentFragmentManager
        .beginTransaction()
        .add(R.id.fragmentContainer, fragment)
        .addToBackStack(fragment::class.simpleName)
        .commit()
}

fun Fragment.back() {
    if (parentFragmentManager.backStackEntryCount > 0) {
        parentFragmentManager.popBackStack()
    } else {
        activity?.finish()
    }
}
