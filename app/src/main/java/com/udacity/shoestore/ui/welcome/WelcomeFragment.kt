package com.udacity.shoestore.ui.welcome

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.ShareViewModel
import com.udacity.shoestore.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {

    private lateinit var binding: FragmentWelcomeBinding
    private lateinit var viewModel: ShareViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_welcome, container, false)

        initViewModel()
        initObservers()

        setBackPressedConfiguration()

        (activity as AppCompatActivity).supportActionBar?.hide()

        return binding.root
    }

    private fun setBackPressedConfiguration() {
        activity?.onBackPressedDispatcher?.addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                val i = Intent()
                i.action = Intent.ACTION_MAIN
                i.addCategory(Intent.CATEGORY_HOME)
                startActivity(i)
            }
        })
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(requireActivity()).get(ShareViewModel::class.java)

        binding.welcomeShareViewModel = viewModel
    }

    private fun initObservers() {
        viewModel.eventNextWelcomePress.observe(viewLifecycleOwner, {
            if (it) {
                goToInstruction()
                viewModel.goToInstructionComplete()
            }
        })
    }

    private fun goToInstruction() {
        findNavController().navigate(R.id.action_welcome_to_instructionList)
    }
}