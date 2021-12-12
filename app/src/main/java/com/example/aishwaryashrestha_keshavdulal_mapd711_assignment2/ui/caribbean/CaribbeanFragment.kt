package com.example.aishwaryashrestha_keshavdulal_mapd711_assignment2.ui.caribbean

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
import com.example.aishwaryashrestha_keshavdulal_mapd711_assignment2.databinding.FragmentCaribbeanBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.net.URL

class CaribbeanFragment : Fragment() {

    companion object {
        fun newInstance() = CaribbeanFragment()
    }

    private lateinit var caribbeanViewModel: CaribbeanViewModel

    private var _binding: FragmentCaribbeanBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var bitmap: Bitmap

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fetchImages()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun fetchImages() {
        val imageView: ImageView = binding.imageView3
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
