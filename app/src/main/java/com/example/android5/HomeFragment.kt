package com.example.android5

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.android5.databinding.ActivityMainBinding
import com.example.android5.databinding.FragmentHomeBinding
import com.example.android5.network.KtorNetwork
import com.example.android5.network.KtorNetworkApi
import com.example.android5.presentation.ApiResponseAdapter
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {
    private var _binding : FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private var _ktorApi: KtorNetworkApi? = null
    private val ktorApi get() = _ktorApi!!

    override fun onAttach(context: Context) {
        super.onAttach(context)
        //Log.d("HomeFragment", "-----onAttach-----")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // Log.d("HomeFragment", "-----onCreate-----")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //Log.d("HomeFragment", "-----onCreateView-----")
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Log.d("HomeFragment", "-----onViewCreated-----")


        _ktorApi = KtorNetwork()

        binding.ktor.setOnClickListener{
            lifecycleScope.launch {
                val characters = ktorApi.getCharacters()
                binding.characterList.adapter = ApiResponseAdapter(characters)
            }
        }

        binding.underground?.setOnClickListener{
            findNavController().navigate(R.id.underground)
        }
    }

    override fun onStart() {
        super.onStart()
        //Log.d("HomeFragment", "-----onStart-----")
    }

    override fun onResume() {
        super.onResume()
        //Log.d("HomeFragment", "-----onResume-----")
    }

    override fun onPause() {
        super.onPause()
       // Log.d("HomeFragment", "-----onPause-----")
    }

    override fun onStop() {
        super.onStop()
        //Log.d("HomeFragment", "-----onStop-----")
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
        //Log.d("HomeFragment", "-----onDestroyView-----")
    }

    override fun onDestroy() {
        super.onDestroy()
       // Log.d("HomeFragment", "-----onDestroy-----")
    }

    override fun onDetach() {
        super.onDetach()
        //Log.d("HomeFragment", "-----onDetach-----")
    }
}