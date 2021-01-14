package com.udacity.shoestore.ui.shoeList

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
import com.udacity.shoestore.databinding.FragmentShoeListBinding

class ShoeListFragment : Fragment() {

    private lateinit var binding: FragmentShoeListBinding

    private lateinit var viewModel: ShoeListViewModel
    private lateinit var viewModelFactory: ShoeListViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)

        initViewModel()
        initObservers()

        return binding.root
    }

    private fun initViewModel() {
        viewModelFactory = ShoeListViewModelFactory()
        viewModel = ViewModelProvider(this, viewModelFactory).get(ShoeListViewModel::class.java)

        binding.shoeListViewModel = viewModel
    }

    private fun initObservers() {
        viewModel.eventAddShoeListPress.observe(viewLifecycleOwner, Observer {
            if (it) {
                goToShoeList()
                viewModel.goToShoeDetailStartComplete()
            }
        })
    }

    private fun goToShoeList() {
        findNavController().navigate(R.id.action_shoeList_to_shoeDetail)
    }
}