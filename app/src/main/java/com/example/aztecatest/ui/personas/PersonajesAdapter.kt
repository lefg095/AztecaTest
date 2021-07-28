package com.example.aztecatest.ui.personas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aztecatest.R
import com.example.aztecatest.databinding.ItemPersonajeBinding
import com.example.aztecatest.model.data.Personajes
import com.squareup.picasso.Picasso

class PersonajesAdapter(
    val personajes: List<Personajes>,
    val mCallBack: ItemPersonaCallback
    ) : RecyclerView.Adapter<PersonajesAdapter.PersonajesViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonajesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PersonajesViewHolder(layoutInflater.inflate(R.layout.item_personaje, parent, false))
    }

    override fun onBindViewHolder(holder: PersonajesViewHolder, position: Int) {
        val personaje = personajes[position]
        holder.bind(personaje, mCallBack)
    }

    override fun getItemCount(): Int {
        return personajes.size
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

