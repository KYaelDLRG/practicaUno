package com.example.practicauno.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.practicauno.databinding.FragmentInfoBinding

class InfoFragment : Fragment() {

    private var _binding: FragmentInfoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.increaseProgressButton.setOnClickListener {
            var currentProgress = binding.progressBarDemo.progress
            currentProgress += 10
            if (currentProgress > 100) {
                currentProgress = 0
            }
            binding.progressBarDemo.progress = currentProgress
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}