package com.example.aishwaryashrestha_keshavdulal_mapd711_assignment2.ui.star

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.aishwaryashrestha_keshavdulal_mapd711_assignment2.databinding.FragmentStarBinding

class StarFragment : Fragment() {

    private lateinit var starViewModel: StarViewModel
    private var _binding: FragmentStarBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        starViewModel =
            ViewModelProvider(this).get(StarViewModel::class.java)

        _binding = FragmentStarBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textStar
        starViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}