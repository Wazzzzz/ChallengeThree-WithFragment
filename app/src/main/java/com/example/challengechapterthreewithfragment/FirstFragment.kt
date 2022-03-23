package com.example.challengechapterthreewithfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.FragmentTransaction

class FirstFragment: Fragment() {

    private lateinit var navigateToSecondFragment: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navigateToSecondFragment = view.findViewById(R.id.navigate_to_second_fragment_button)

        navigateToSecondFragment.setOnClickListener {
            val fragmentManager = parentFragmentManager
            val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
            val secondFragment = SecondFragment()
            fragmentTransaction.apply {
                replace(R.id.frame_layout_container, secondFragment, SecondFragment::class.java.simpleName)
                addToBackStack(null)
                commit()
            }
        }
    }
}