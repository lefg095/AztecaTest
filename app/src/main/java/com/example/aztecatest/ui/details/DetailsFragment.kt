package com.example.aztecatest.ui.details

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aztecatest.databinding.FragmentDetailsBinding
import com.example.aztecatest.model.data.Personajes
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment: Fragment() {
    private lateinit var binding: FragmentDetailsBinding
    private var adapter: EpisodioAdapter? = null
    private var personaName = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initComponents()
    }

    private fun initComponents() {
        val personas = arguments?.get("persona") as Personajes
        personas.let {
            setData(personas)
        }
        val toolbar = binding.toolbar
        toolbar.setTitle(personas.name)
    }

    private fun initRecyclerView(episodios: List<String>){
        val mLayoutManager: RecyclerView.LayoutManager = LinearLayoutManager(activity)
        binding.recyclerEpisodios.setLayoutManager(mLayoutManager)
        adapter = EpisodioAdapter(episodios)
        binding.recyclerEpisodios.setAdapter(adapter)
    }


    @SuppressLint("SetTextI18n")
    private fun setData(persona: Personajes) {
        Picasso.get().load(persona.image).into(binding.avatar)
        binding.name.text = "Nombre: ${persona.name}"
        binding.especie.text = "Especie: ${persona.species}"
        binding.genero.text = "Genero: ${persona.gender}"
        binding.origen.text = "Origen: ${persona.origin!!.name}"
        initRecyclerView(persona.episode)
    }
}