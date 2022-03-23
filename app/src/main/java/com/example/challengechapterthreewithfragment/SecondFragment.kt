package com.example.challengechapterthreewithfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class SecondFragment : Fragment() {

    private lateinit var nameEditText: EditText
    private lateinit var navigateToThirdButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        nameEditText = view.findViewById(R.id.name_edit_text)
        navigateToThirdButton = view.findViewById(R.id.navigate_to_third_fragment_button)

        navigateToThirdButton.setOnClickListener {
            val fragmentManager: FragmentManager = parentFragmentManager
            val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
            val thirdFragment = ThirdFragment()

            var name = nameEditText.text.toString().trim()

            val bundle = Bundle()
            bundle.putString("name_key", name)
            thirdFragment.arguments = bundle

            fragmentTransaction.apply {
                replace(R.id.frame_layout_container, thirdFragment, ThirdFragment::class.java.simpleName)
                addToBackStack(null)
                commit()
            }
        }
    }
}