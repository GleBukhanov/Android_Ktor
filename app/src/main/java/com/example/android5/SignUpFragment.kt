package com.example.android5

import android.os.Bundle
import android.util.Log
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import com.example.android5.databinding.FragmentSignUpBinding
import com.google.android.material.textfield.TextInputEditText

class SignUpFragment : Fragment() {
    private var _binding: FragmentSignUpBinding? = null
    private val binding get() = _binding!!
    private lateinit var nameTextField: TextInputEditText
    private lateinit var emailTextField: TextInputEditText
    private lateinit var passwordTextField: TextInputEditText
    private lateinit var confirmPasswordField: TextInputEditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSignUpBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        nameTextField = binding!!.signUpName
        emailTextField = binding!!.signUpEmail
        passwordTextField = binding!!.signUpPassword
        confirmPasswordField = binding!!.signUpConfirmPassword
        binding.signUpActivityButton.setOnClickListener {
            if (!nameTextField.text.toString()!!.equals("") &&
                !emailTextField.text.toString()!!.equals("") &&
                !passwordTextField.text.toString()!!.equals("") &&
                !confirmPasswordField.text.toString()!!.equals("") &&
                Patterns.EMAIL_ADDRESS.matcher(emailTextField.text.toString()).matches() &&
                passwordTextField.text.toString() == confirmPasswordField.text.toString()
            ) {

                val bundle = bundleOf("name" to binding.signUpName.text.toString(),"email" to binding.signUpEmail.text.toString(),"password" to binding.signUpPassword.text.toString() )
                view.findNavController().navigate(R.id.action_signUpFragment_to_signInFragment, args = bundle)
            }
            else {
                Log.e("gg","gg")
            }
        }
    }

        override fun onDestroy() {
            super.onDestroy()
            _binding = null
        }
    }
