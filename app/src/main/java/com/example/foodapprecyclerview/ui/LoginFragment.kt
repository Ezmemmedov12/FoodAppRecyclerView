package com.example.foodapprecyclerview.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController

import com.example.foodapprecyclerview.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {
    private var _binding:FragmentLoginBinding?=null
    private val binding get()=_binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentLoginBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.backButton.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToIntroFragment())
        }
        click()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }


    fun click(){
        binding.button.setOnClickListener {
            val email=binding.editTextTextEmailAddress.text
            val password=binding.editTextTextPassword.text
            val trueEmail="ezmemmedov945@gmail.com"
            val truePassword="mayil123"
            val sizePassword=password.length
            if(email.
                isNotEmpty() && password.isNotEmpty()){
                if(sizePassword<5){
                    Toast.makeText( context,"Password must be at least 5 letters", Toast.LENGTH_LONG).show()
                }
                if(email.toString()==trueEmail && password.toString()==truePassword){
                    findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToHomeFragment())
                    binding.editTextTextEmailAddress.text.clear()
                    binding.editTextTextPassword.text.clear()
                } else{
                    Toast.makeText( context,"Email or Password is incorrect", Toast.LENGTH_LONG).show()
                }
            }
            else{
                Toast.makeText( context,"Email or Password can't be empty!", Toast.LENGTH_LONG).show()
            }
        }
    }
}

