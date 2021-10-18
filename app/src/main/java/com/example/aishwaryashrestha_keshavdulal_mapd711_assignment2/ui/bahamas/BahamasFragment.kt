package com.example.aishwaryashrestha_keshavdulal_mapd711_assignment2.ui.bahamas

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.aishwaryashrestha_keshavdulal_mapd711_assignment2.databinding.FragmentBahamasBinding

class BahamasFragment : Fragment() {

    companion object {
        fun newInstance() = BahamasFragment()
    }

    private lateinit var bahamasViewModel: BahamasViewModel

    private var _binding: FragmentBahamasBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bahamasViewModel =
            ViewModelProvider(this).get(BahamasViewModel::class.java)

        _binding = FragmentBahamasBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textBahamas
        bahamasViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}