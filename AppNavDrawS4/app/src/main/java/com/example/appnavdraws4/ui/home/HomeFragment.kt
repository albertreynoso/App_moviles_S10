package com.example.appnavdraws4.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.appnavdraws4.databinding.FragmentHomeBinding
import com.example.appnavdraws4.R


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        //Declaración de las variables de la pantalla
        val btnToggleGrafico = root.findViewById<Button>(R.id.btnToggleGrafico)
        val grafico = root.findViewById<View>(R.id.graficoSimulado)
        //Función del boton cuando sea presionado
        btnToggleGrafico.setOnClickListener{
            //Logica simple para mostrar el grafico y para ocultarlo
            if(grafico.visibility == View.GONE){
                grafico.visibility = View.VISIBLE
                btnToggleGrafico.text = "Ocultar Gráfico"
            } else {
                grafico.visibility = View.GONE
                btnToggleGrafico.text = "Mostrar Gráfico"

            }
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}