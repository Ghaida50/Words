package com.example.wordsapp.UI

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wordsapp.R
import com.example.wordsapp.WordAdapter
import com.example.wordsapp.databinding.FragmentLetterListBinding
import com.example.wordsapp.databinding.FragmentWordListBinding


class WordListFragment : Fragment() {
    private var _binding :FragmentWordListBinding? =null
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView
    private lateinit var letterId: String
    companion object {
        const val LETTER = "letter"
        const val SEARCH_PREFIX = "https://www.google.com/search?q="
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            letterId = it.getString(LETTER).toString()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding= FragmentWordListBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }//end onCreateView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = binding.recyclerView
        recyclerView.layoutManager= LinearLayoutManager(requireContext())
      //  recyclerView.adapter= WordAdapter(activity?.intent?.extras?.getString(LETTER).toString(),requireContext())
        recyclerView.adapter = WordAdapter(letterId, requireContext())

        recyclerView.addItemDecoration(
            DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        )
    }// end onViewCreated

    override fun onDestroyView() {
        super.onDestroyView()
        _binding= null
    }// end onDestroyView


}