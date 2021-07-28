package com.example.aztecatest.ui.details

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aztecatest.R
import com.example.aztecatest.databinding.ItemEpisodioBinding

class EpisodioAdapter(
    val episodios: List<String>
): RecyclerView.Adapter<EpisodioAdapter.EpisodiosViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodiosViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return EpisodiosViewHolder(layoutInflater.inflate(R.layout.item_episodio, parent, false))
    }

    override fun onBindViewHolder(holder: EpisodiosViewHolder, position: Int) {
        val episodio = episodios[position]
        holder.bind(episodio)
    }

    override fun getItemCount(): Int {
        return  episodios.size
    }

    class EpisodiosViewHolder (view: View): RecyclerView.ViewHolder(view){
        private val binding = ItemEpisodioBinding.bind(view)
        fun bind(episodio: String) {
            binding.tvEpisodio.text = episodio
        }

    }
}
/*
    override fun onBindViewHolder(holder: PersonajesViewHolder, position: Int) {
        val personaje = personajes[position]
        holder.bind(personaje, mCallBack)
    }

    class PersonajesViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val binding = ItemPersonajeBinding.bind(view)
        fun bind(persona: Personajes , mCallBack: ItemPersonaCallback){
            Picasso.get().load(persona.image).into(binding.imageViewPhoto)
            binding.namePersonaje.text = persona.name
            binding.imageViewPhoto.setOnClickListener {
                mCallBack.showDetailClicket(persona)
            }
        }
    }
}


* */
