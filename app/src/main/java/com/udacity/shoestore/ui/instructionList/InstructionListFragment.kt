package com.udacity.shoestore.ui.instructionList

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
import com.udacity.shoestore.databinding.FragmentInstructionListBinding

class InstructionListFragment : Fragment() {

    private lateinit var binding: FragmentInstructionListBinding

    private lateinit var listViewModel: ShareViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_instruction_list, container, false)

        initViewModel()
        initObservers()

        (activity as AppCompatActivity).supportActionBar?.hide()

        return binding.root
    }

    private fun initViewModel() {
        listViewModel = ViewModelProvider(requireActivity()).get(ShareViewModel::class.java)

        binding.instructionListShareViewModel = listViewModel
    }

    private fun initObservers() {
        listViewModel.eventNextInstructionPress.observe(viewLifecycleOwner, {
            if (it) {
                goToInstructionDetail()
                listViewModel.goToInstructionDetailComplete()
            }
        })
    }

    private fun goToInstructionDetail() {
        findNavController().navigate(R.id.action_instructionList_to_instructionDetail)
    }
}