package com.example.android5

import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.android5.databinding.FragmentSignInBinding
import com.google.android.material.textfield.TextInputEditText


class SignInFragment : Fragment() {
    private var _binding: FragmentSignInBinding?=null
    private val binding get() = _binding!!

    private lateinit var nameTextField: TextInputEditText
    private lateinit var emailTextField: TextInputEditText
    private lateinit var passwordTextField: TextInputEditText


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSignInBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        nameTextField= binding!!.signInName
        emailTextField = binding!!.signInActivityEmail
        passwordTextField = binding!!.signInPassword

        binding.signInActivityEnter.setOnClickListener {
           if( !nameTextField.text.toString()!!.equals("") &&
                    !emailTextField.text.toString()!!.equals("") &&
                    !passwordTextField.text.toString()!!.equals("") &&Patterns.EMAIL_ADDRESS.matcher(emailTextField.text.toString()).matches()){
               val bundle = bundleOf("name" to binding.signInName.text.toString(),"email" to binding.signInActivityEmail.text.toString())
               findNavController().navigate(R.id.homeFragment,args = bundle)
           }
            //MAIN.navController.navigate(R.id.action_signInFragment_to_homeFragment)
        }

        nameTextField.setText(arguments?.getString("name"))
        emailTextField.setText(arguments?.getString("email"))
        passwordTextField.setText(arguments?.getString("password"))
        binding.signInActivityRegistration.setOnClickListener{
            MAIN.navController.navigate(R.id.action_signInFragment_to_signUpFragment)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }
}