package com.udacity.shoestore.ui.instruction

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentInstructionBinding
import com.udacity.shoestore.ui.welcome.WelcomeViewModel
import com.udacity.shoestore.ui.welcome.WelcomeViewModelFactory

/**
 * A simple [Fragment] subclass.
 * Use the [InstructionFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class InstructionFragment : Fragment() {

    private lateinit var binding: FragmentInstructionBinding

    private lateinit var viewModel: InstructionViewModel
    private lateinit var viewModelFactory: InstructionViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_instruction, container, false)

        initViewModel()
        initObservers()

        return binding.root
    }

    private fun initViewModel() {
        viewModelFactory = InstructionViewModelFactory()
        viewModel = ViewModelProvider(this, viewModelFactory).get(InstructionViewModel::class.java)

        binding.instructionViewModel = viewModel
    }

    private fun initObservers() {
        viewModel.eventNextInstructionPress.observe(viewLifecycleOwner, Observer {
            if (it) {
                goToShoeList()
                viewModel.goToShoeListStartComplete()
            }
        })
    }

    private fun goToShoeList() {
        findNavController().navigate(R.id.action_instruction_to_shoeList)
    }
}