package com.udacity.shoestore.ui.shoeList

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.ShareViewModel
import com.udacity.shoestore.databinding.LayoutElementShoeBinding

class ShoeListFragment : Fragment() {

    private lateinit var binding: FragmentShoeListBinding
    private lateinit var viewModel: ShareViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setBackPressedConfiguration()
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)

        initViewModel()
        initObservers()

        (activity as AppCompatActivity).supportActionBar?.show()
        (activity as AppCompatActivity).supportActionBar!!.setDisplayHomeAsUpEnabled(false)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        findNavController().navigate(R.id.action_shoeList_to_loginFragment)
        return super.onOptionsItemSelected(item)
    }

    private fun setBackPressedConfiguration() {
        activity?.onBackPressedDispatcher?.addCallback(this, object : OnBackPressedCallback(true) {
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

        binding.listShareViewModel = viewModel
    }

    private fun initObservers() {
        viewModel.eventAddShoeListPress.observe(viewLifecycleOwner, {
            if (it) {
                goToShoeList()
                viewModel.goToShoeDetailStartComplete()
            }
        })

        viewModel.shoesList.observe(viewLifecycleOwner, { listShoes ->
            initShoeList(listShoes)
        })
    }

    private fun goToShoeList() {
        findNavController().navigate(R.id.action_shoeList_to_shoeDetail)
    }

    private fun initShoeList(listShoes: MutableList<Shoe>) {
        val parentLayout = binding.shoeElementList

        var index = 0
        while (index < listShoes.size) {
            val shoeBinding: LayoutElementShoeBinding = DataBindingUtil.inflate(
                layoutInflater,
                R.layout.layout_element_shoe,
                parentLayout,
                false
            )

            val shoe = listShoes[index]
            shoeBinding.nameShoeList.text = shoe.name
            shoeBinding.nameCompanyList.text = shoe.company
            shoeBinding.sizeShoeList.text = shoe.size.toString()
            when (shoe.modelsAvailable[shoe.modelShoe]) {
                "model_0" -> shoeBinding.imageShoeList.setImageResource(R.drawable.model_0)
                "model_1" -> shoeBinding.imageShoeList.setImageResource(R.drawable.model_1)
                "model_2" -> shoeBinding.imageShoeList.setImageResource(R.drawable.model_2)
                "model_3" -> shoeBinding.imageShoeList.setImageResource(R.drawable.model_3)
                "model_4" -> shoeBinding.imageShoeList.setImageResource(R.drawable.model_4)
                "model_5" -> shoeBinding.imageShoeList.setImageResource(R.drawable.model_5)
            }
            parentLayout.addView(shoeBinding.root)

            index++
        }
    }
}