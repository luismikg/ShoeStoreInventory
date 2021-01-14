package com.udacity.shoestore.ui.shoeDetail

import android.app.AlertDialog
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
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe

class ShoeDetailFragment : Fragment() {

    private lateinit var binding: FragmentShoeDetailBinding

    private lateinit var viewModel: ShoeDetailViewModel
    private lateinit var viewModelFactory: ShoeDetailViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)

        initViewModel()
        initObservers()

        changePictureShoeDetailPress("model_0")

        return binding.root
    }

    private fun initViewModel() {

        viewModelFactory = ShoeDetailViewModelFactory()
        viewModel = ViewModelProvider(this, viewModelFactory).get(ShoeDetailViewModel::class.java)

        binding.shoeDetailViewModel = viewModel
        binding.shoe = viewModel.shoe
    }

    private fun initObservers() {
        viewModel.eventSaveShoeDetailPress.observe(viewLifecycleOwner, Observer {
            if (it) {
                saveShoeDetail()
                viewModel.saveShoeDetailComplete()
            }
        })

        viewModel.eventCancelShoeDetailPress.observe(viewLifecycleOwner, Observer {
            if (it) {
                cancelShoeDetail()
                viewModel.cancelShoeDetailComplete()
            }
        })

        viewModel.eventSizeViewShoeDetailPress.observe(viewLifecycleOwner, Observer { view ->
            view?.let {
                clearSizeShoeDetail()
                changeBackbroundSizeSelectedShoeDetail(view)
            }
        })

        viewModel.eventPictureShoeDetailPress.observe(
            viewLifecycleOwner,
            Observer { nameModelShoe ->
                nameModelShoe?.let {
                    changePictureShoeDetailPress(nameModelShoe)
                }
            })

        viewModel.eventSaveFailByNameShoeDetail.observe(viewLifecycleOwner, Observer {
            if (it) {
                val message = "The name of the shoe is required"
                showAlert(message)
                viewModel.saveFailByNameShoeDetailComplete()
            }
        })

        viewModel.eventSaveFailBySizeShoeDetail.observe(viewLifecycleOwner, Observer {
            if (it) {
                val message = "The shoe's size is required"
                showAlert(message)
                viewModel.saveFailBySizeShoeDetailComplete()
            }
        })

        viewModel.eventSaveFailByNameCompanyShoeDetail
            .observe(viewLifecycleOwner, Observer {
                if (it) {
                    val message = "The name of the company is required"
                    showAlert(message)
                    viewModel.saveFailByNameCompanyShoeDetailComplete()
                }
            })
    }

    private fun saveShoeDetail() {
        findNavController().popBackStack()
    }

    private fun cancelShoeDetail() {
        findNavController().popBackStack()
    }

    private fun clearSizeShoeDetail() {
        binding.eightButton.setBackgroundResource(R.drawable.rounded_circle_disabled)
        binding.nineButton.setBackgroundResource(R.drawable.rounded_circle_disabled)
        binding.tenButton.setBackgroundResource(R.drawable.rounded_circle_disabled)
        binding.elevenButton.setBackgroundResource(R.drawable.rounded_circle_disabled)
        binding.twelveButton.setBackgroundResource(R.drawable.rounded_circle_disabled)
    }

    private fun changeBackbroundSizeSelectedShoeDetail(view: View) {
        view.setBackgroundResource(R.drawable.rounded_circle_enabled)
    }

    private fun changePictureShoeDetailPress(nameModelShoe: String) {
        when (nameModelShoe) {
            "model_0" -> binding.imageShoe.setImageResource(R.drawable.model_0)
            "model_1" -> binding.imageShoe.setImageResource(R.drawable.model_1)
            "model_2" -> binding.imageShoe.setImageResource(R.drawable.model_2)
            "model_3" -> binding.imageShoe.setImageResource(R.drawable.model_3)
            "model_4" -> binding.imageShoe.setImageResource(R.drawable.model_4)
            "model_5" -> binding.imageShoe.setImageResource(R.drawable.model_5)
        }
    }

    private fun showAlert(message: String) {
        val builder = AlertDialog.Builder(context)

        with(builder)
        {
            setTitle("Error")
            setMessage(message)
            setPositiveButton("OK", null)
            show()
        }
    }
}