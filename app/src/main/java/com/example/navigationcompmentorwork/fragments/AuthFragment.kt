package com.example.navigationcompmentorwork.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.navigationcompmentorwork.R
import com.example.navigationcompmentorwork.databinding.FragmentAuthBinding

class AuthFragment : Fragment() {

    private var binding: FragmentAuthBinding? = null
    private var login: String? = null
    private var password: String? = null
    private var name: String? = null
    private var surname: String? = null
    private var email: String? = null
    private var gender: String? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentAuthBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        parentFragmentManager.setFragmentResultListener("data", viewLifecycleOwner) { _, bundle ->
//            login = bundle.getString("login")
//            password = bundle.getString("password")
//            name = bundle.getString("name")
//            surname = bundle.getString("surname")
//            email = bundle.getString("email")
//            gender = bundle.getString("gender")
//            binding?.edLogin?.setText(login)
//            binding?.edPassword?.setText(password)
//        }

        binding?.btLogIn?.setOnClickListener {
//            logIn()
            logInSafeArgs()
        }
        binding?.btSignUp?.setOnClickListener {
            findNavController().navigate(R.id.action_authFragment_to_signFragment)
        }
    }

    private fun logIn() {
        val etLogin = binding?.edLogin?.text.toString()
        val etPassword = binding?.edPassword?.text.toString()

        if (etLogin == login || etPassword == password) {

            val bundle = bundleOf(
                "name" to name,
                "surname" to surname,
                "email" to email,
                "gender" to gender
            )
            findNavController().navigate(R.id.action_authFragment_to_dataFragment, bundle)
        } else {
            if (binding?.edLogin?.text.isNullOrEmpty() || binding?.edPassword?.text.isNullOrEmpty()) {
                Toast.makeText(context, "Введите данные!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Неверный логин или пароль!", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
    private fun logInSafeArgs() {
        val args = AuthFragmentArgs.fromBundle(requireArguments())
        val login = args.login
        val password = args.password
        val name = args.name
        val surname = args.surname
        val email = args.email
        val gender = args.gender

        val etLogin = binding?.edLogin?.text.toString()
        val etPassword = binding?.edPassword?.text.toString()

        if (etLogin == login || etPassword == password) {
            val action = AuthFragmentDirections.actionAuthFragmentToDataFragment(
                name = name.toString(),
                surname = surname.toString(),
                email = email.toString(),
                gender = gender.toString()
            )
            findNavController().navigate(action)

        } else {
            if (binding?.edLogin?.text.isNullOrEmpty() || binding?.edPassword?.text.isNullOrEmpty()) {
                Toast.makeText(context, "Введите данные!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Неверный логин или пароль!", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
}

