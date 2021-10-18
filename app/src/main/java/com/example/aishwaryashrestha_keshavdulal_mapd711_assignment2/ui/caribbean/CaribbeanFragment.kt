package com.example.aishwaryashrestha_keshavdulal_mapd711_assignment2.ui.caribbean

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.aishwaryashrestha_keshavdulal_mapd711_assignment2.databinding.FragmentCaribbeanBinding
class CaribbeanFragment : Fragment() {

    companion object {
        fun newInstance() = CaribbeanFragment()
    }

    private lateinit var caribbeanViewModel: CaribbeanViewModel

    private var _binding: FragmentCaribbeanBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        caribbeanViewModel =
            ViewModelProvider(this).get(CaribbeanViewModel::class.java)

        _binding = FragmentCaribbeanBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textCaribbean
        caribbeanViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}