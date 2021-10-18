package com.example.aishwaryashrestha_keshavdulal_mapd711_assignment2.ui.sampler

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.aishwaryashrestha_keshavdulal_mapd711_assignment2.databinding.FragmentSamplerBinding

class SamplerFragment : Fragment() {

    private lateinit var samplerViewModel: SamplerViewModel
    private var _binding: FragmentSamplerBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        samplerViewModel =
            ViewModelProvider(this).get(SamplerViewModel::class.java)

        _binding = FragmentSamplerBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textSampler
        samplerViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}