package com.udacity.shoestore.ui.instructionDetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.ShareViewModel
import com.udacity.shoestore.databinding.FragmentInstructionDetailBinding

class InstructionDetailFragment : Fragment() {

    private lateinit var binding: FragmentInstructionDetailBinding
    private lateinit var viewModel: ShareViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_instruction_detail, container, false)

        initViewModel()
        initObservers()

        (activity as AppCompatActivity).supportActionBar?.hide()

        return binding.root
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(requireActivity()).get(ShareViewModel::class.java)

        binding.instructionDetailShareViewModel = viewModel
    }

    private fun initObservers() {
        viewModel.eventNextInstructionDetailPress.observe(viewLifecycleOwner, {
            if (it) {
                goToShoeList()
                viewModel.goToShoeListComplete()
            }
        })
    }

    private fun goToShoeList() {
        findNavController().navigate(R.id.action_instructionDetail_to_shoeList)
    }
}