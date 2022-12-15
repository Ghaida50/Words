package com.example.wordsapp.UI

import android.os.Bundle
import android.view.*
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wordsapp.LetterAdapter
import com.example.wordsapp.R
import com.example.wordsapp.databinding.FragmentLetterListBinding


class LetterListFragment : Fragment() {

    private var _binding : FragmentLetterListBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView
    private var isLinearLayoutManager = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }//end onCreate

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding=FragmentLetterListBinding.inflate(inflater,container,false)
         val view = binding.root
         return view
    }//end onCreateView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
       recyclerView = binding.recyclerView
        chooseLayout()
    }// end onViewCreated

    override fun onDestroyView() {
        super.onDestroyView()
        _binding= null
    }// end onDestroyView

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.layout_menu,menu)

        val layoutButton = menu.findItem(R.id.action_switch_layout)
       // setIcon(layoutButton)
    }// end onCreateOptionsMenu

    private fun chooseLayout(){
        when(isLinearLayoutManager){
            true -> {
                recyclerView.layoutManager = LinearLayoutManager(context)
                recyclerView.adapter = LetterAdapter()
            }// end true

            false ->  {
                recyclerView.layoutManager = GridLayoutManager(context,4)
                recyclerView.adapter = LetterAdapter()
            }// end false
        }//end when
    }// end chooseLayout

    private fun setIcon(menuItem: MenuItem?) {
        if (menuItem == null)
            return

        menuItem.icon =
            if (isLinearLayoutManager)
                ContextCompat.getDrawable(this.requireContext(), R.drawable.ic_grid_layout)
            else ContextCompat.getDrawable(this.requireContext(), R.drawable.ic_linear_layout)
    }// end setIcon

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_switch_layout -> {
                isLinearLayoutManager = !isLinearLayoutManager
                chooseLayout()
                setIcon(item)

                return true
            }

            else -> super.onOptionsItemSelected(item)
        }//end when
    }// end onOptionsItemSelected
}