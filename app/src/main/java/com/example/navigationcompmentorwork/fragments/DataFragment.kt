package com.example.navigationcompmentorwork.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.navigationcompmentorwork.databinding.FragmentDataBinding

class DataFragment : Fragment() {
    private var binding: FragmentDataBinding? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentDataBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        setData()
        setDataSafeArgs()
    }

    private fun setData() {
        val name = arguments?.getString("name")
        val surname = arguments?.getString("surname")
        val email = arguments?.getString("email")
        val gender = arguments?.getString("gender")

        binding?.tvName?.text = name
        binding?.tvSurName?.text = surname
        binding?.tvEmail?.text = email
        binding?.tvGender?.text = gender
    }

    private fun setDataSafeArgs() {
        val args = DataFragmentArgs.fromBundle(requireArguments())
        binding?.tvName?.text = args.name
        binding?.tvSurName?.text = args.surname
        binding?.tvEmail?.text = args.email
        binding?.tvGender?.text = args.gender
    }

}