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
import com.udacity.shoestore.databinding.FragmentInstructionListBinding

class InstructionListFragment : Fragment() {

    private lateinit var binding: FragmentInstructionListBinding

    private lateinit var listViewModel: InstructionListViewModel
    private lateinit var listViewModelFactory: InstructionListViewModelFactory

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
        listViewModelFactory = InstructionListViewModelFactory()
        listViewModel = ViewModelProvider(this, listViewModelFactory).get(InstructionListViewModel::class.java)

        binding.instructionListViewModel = listViewModel
    }

    private fun initObservers() {
        listViewModel.eventNextInstructionDetailPress.observe(viewLifecycleOwner, {
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