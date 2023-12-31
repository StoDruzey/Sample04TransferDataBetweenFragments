package com.example.sample04transferdatabetweenfragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, FragmentFirst())
//            .addToBackStack(null)
            .commit()
    }
}

fun Fragment.addFragment(fragment: Fragment) {

    val activity = requireActivity() as? MainActivity ?: error("error")
    activity
        .supportFragmentManager
        .beginTransaction()
        .replace(R.id.fragment_container, fragment)
        .addToBackStack(null)
        .commit()
}