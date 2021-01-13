package com.udacity.shoestore.ui.welcome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {

    private lateinit var binding: FragmentWelcomeBinding
    private lateinit var viewModel: WelcomeViewModel
    private lateinit var viewModelFactory: WelcomeViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_welcome, container, false)

        initViewModel()
        initObservers()

        return binding.root
    }

    private fun initViewModel(){
        viewModelFactory = WelcomeViewModelFactory()
        viewModel = ViewModelProvider(this, viewModelFactory).get(WelcomeViewModel::class.java)

        binding.welcomeViewModel = viewModel
    }

    private fun initObservers(){
        viewModel.eventNextInstructionPress.observe(viewLifecycleOwner, Observer {
            if(it){
                goToInstruction()
                viewModel.goToInstructionComplete()
            }
        })
    }

    private fun goToInstruction(){
        findNavController().navigate(R.id.action_welcome_to_instruction)
    }
}