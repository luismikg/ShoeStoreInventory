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
import kotlinx.android.synthetic.main.layout_element_shoe.view.*

class ShoeListFragment : Fragment() {

    private lateinit var binding: FragmentShoeListBinding

    private lateinit var viewModel: ShoeListViewModel
    private lateinit var viewModelFactory: ShoeListViewModelFactory

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
        viewModelFactory = ShoeListViewModelFactory()
        viewModel = ViewModelProvider(this, viewModelFactory).get(ShoeListViewModel::class.java)

        binding.shoeListViewModel = viewModel
    }

    private fun initObservers() {
        viewModel.eventAddShoeListPress.observe(viewLifecycleOwner, {
            if (it) {
                goToShoeList()
                viewModel.goToShoeDetailStartComplete()
            }
        })

        findNavController().currentBackStackEntry?.savedStateHandle?.getLiveData<Shoe>("shoe")
            ?.observe(
                viewLifecycleOwner
            ) { shoe ->
                addNewShoe(shoe)
            }

    }

    private fun goToShoeList() {
        findNavController().navigate(R.id.action_shoeList_to_shoeDetail)
    }

    private fun addNewShoe(newShoe: Shoe) {
        val parentLayout = binding.shoeElementList

        viewModel.saveNewShoe(newShoe)

        var index = 0
        while (index < viewModel.getShoeSize()) {
            val shoeLayout =
                layoutInflater.inflate(R.layout.layout_element_shoe, parentLayout, false)

            val shoe = viewModel.getShoe(index)
            shoeLayout.nameShoeList.text = shoe.name
            shoeLayout.nameCompanyList.text = shoe.company
            shoeLayout.sizeShoeList.text = shoe.size.toString()
            when (shoe.modelsAvailable[shoe.modelShoe]) {
                "model_0" -> shoeLayout.imageShoeList.setImageResource(R.drawable.model_0)
                "model_1" -> shoeLayout.imageShoeList.setImageResource(R.drawable.model_1)
                "model_2" -> shoeLayout.imageShoeList.setImageResource(R.drawable.model_2)
                "model_3" -> shoeLayout.imageShoeList.setImageResource(R.drawable.model_3)
                "model_4" -> shoeLayout.imageShoeList.setImageResource(R.drawable.model_4)
                "model_5" -> shoeLayout.imageShoeList.setImageResource(R.drawable.model_5)
            }
            parentLayout.addView(shoeLayout)

            index++
        }
    }
}