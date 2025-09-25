package com.example.practicauno.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.practicauno.R
import com.example.practicauno.databinding.FragmentSelectionBinding

class SelectionFragment : Fragment() {

    private var _binding: FragmentSelectionBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSelectionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.checkStatusButton.setOnClickListener {
            val results = StringBuilder()

            val terminos = if (binding.checkboxDemo.isChecked) "Sí" else "No"
            results.append("Términos aceptados: $terminos\n")

            val selectedRadioId = binding.radioGroupDemo.checkedRadioButtonId
            val opcion = when (selectedRadioId) {
                R.id.radio_button_1 -> "Opción A"
                R.id.radio_button_2 -> "Opción B"
                else -> "Ninguna"
            }
            results.append("Opción seleccionada: $opcion\n")

            val notificaciones = if (binding.switchDemo.isChecked) "Activadas" else "Desactivadas"
            results.append("Notificaciones: $notificaciones")

            binding.selectionResultText.text = results.toString()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}