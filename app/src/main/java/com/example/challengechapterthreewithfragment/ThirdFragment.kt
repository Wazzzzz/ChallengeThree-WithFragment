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
import org.w3c.dom.Text

class ThirdFragment : Fragment() {

    private lateinit var nameTextView: TextView
    private lateinit var navigateToFourthButton: Button
    private lateinit var ageTextView: TextView
    private lateinit var addressTextView: TextView
    private lateinit var jobTextView: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        nameTextView = view.findViewById(R.id.name_text_view)
        navigateToFourthButton = view.findViewById(R.id.navigate_to_fourth_fragment_button)
        ageTextView = view.findViewById(R.id.age_text_view)
        addressTextView = view.findViewById(R.id.address_text_view)
        jobTextView = view.findViewById(R.id.job_text_view)

        val name = arguments?.getString("name_key")

        navigateToFourthButton.setOnClickListener {
            val fragmentManager: FragmentManager = parentFragmentManager
            val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
            val fourthFragment = FourthFragment()
            fragmentTransaction.apply {
                replace(R.id.frame_layout_container, fourthFragment, FourthFragment::class.java.simpleName)
                addToBackStack(null)
                commit()
            }
            val bundle = Bundle()
            bundle.putString("name_key", name)
            fourthFragment.arguments = bundle
        }

        val age = arguments?.getString("age_key")
        val address = arguments?.getString("address_key")
        val job = arguments?.getString("job_key")

        nameTextView.text = name
        ageTextView.text = age
        addressTextView.text = address
        jobTextView.text = job
    }

}