package com.example.appnavdraws4.ui.slideshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.appnavdraws4.databinding.FragmentSlideshowBinding

import android.animation.ObjectAnimator
import com.example.appnavdraws4.R

class SlideshowFragment : Fragment() {

    private var _binding: FragmentSlideshowBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val root = inflater.inflate(R.layout.fragment_slideshow, container, false)

        val circulo = root.findViewById<View>(R.id.circuloAnimado)
        val animator = ObjectAnimator.ofFloat(circulo, "translationX", 0f, 500f).apply {
            duration=1000
            repeatMode= ObjectAnimator.REVERSE
            repeatCount= ObjectAnimator.INFINITE
            start()
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}