package com.example.challengechapterthreewithfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class FourthFragment : Fragment() {

    private lateinit var ageEditText: EditText
    private lateinit var addressEditText: EditText
    private lateinit var jobEditText: EditText
    private lateinit var navigateToThirdButton2: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fourth, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ageEditText = view.findViewById(R.id.age_edit_text)
        addressEditText = view.findViewById(R.id.address_edit_text)
        jobEditText = view.findViewById(R.id.job_edit_text)
        navigateToThirdButton2 = view.findViewById(R.id.navigate_to_third_fragment_button_2)

        navigateToThirdButton2.setOnClickListener {
            val fragmentManager: FragmentManager = parentFragmentManager
            val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
            val thirdFragment = ThirdFragment()

            val name = arguments?.getString("name_key")

            var age = ageEditText.text.toString().trim()
            var address = addressEditText.text.toString().trim()
            var job = jobEditText.text.toString().trim()

            val bundle = Bundle()
            bundle.putString("name_key", name)
            bundle.putString("age_key", age)
            bundle.putString("address_key", address)
            bundle.putString("job_key", job)
            thirdFragment.arguments = bundle

            fragmentTransaction.apply {
                replace(R.id.frame_layout_container, thirdFragment, ThirdFragment::class.java.simpleName)
                addToBackStack(null)
                commit()
            }

        }

    }
}