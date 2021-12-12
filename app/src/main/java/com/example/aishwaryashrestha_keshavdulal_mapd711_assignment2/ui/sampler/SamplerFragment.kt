package com.example.aishwaryashrestha_keshavdulal_mapd711_assignment2.ui.sampler

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.aishwaryashrestha_keshavdulal_mapd711_assignment2.databinding.FragmentSamplerBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.net.URL

class SamplerFragment : Fragment() {

    private lateinit var samplerViewModel: SamplerViewModel
    private var _binding: FragmentSamplerBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var bitmap: Bitmap

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fetchImages()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun fetchImages() {
        val imageView: ImageView = binding.imageView5
        val url = URL("https://picsum.photos/320/180")

        GlobalScope.launch(Dispatchers.IO) {
            println("### - @GlobalScope.launch")
            bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream())

            // Switching scope to Main Thread to access the View
            launch(Dispatchers.Main) {
                imageView?.setImageBitmap(bitmap)
            }
        }
    }
}
