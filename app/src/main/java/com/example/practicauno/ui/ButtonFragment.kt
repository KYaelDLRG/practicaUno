package com.example.practicauno.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.practicauno.databinding.FragmentButtonBinding

class ButtonFragment : Fragment() {

    private var _binding: FragmentButtonBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentButtonBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.demoButton.setOnClickListener {
            binding.buttonResultText.text = "¡Botón de texto pulsado!"
            Toast.makeText(context, "Botón normal presionado", Toast.LENGTH_SHORT).show()
        }

        binding.demoImageButton.setOnClickListener {
            binding.buttonResultText.text = "¡Botón de imagen pulsado!"
            Toast.makeText(context, "Botón de imagen presionado", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}