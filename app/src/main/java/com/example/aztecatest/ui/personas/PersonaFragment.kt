package com.example.aztecatest.ui.personas

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.aztecatest.R
import com.example.aztecatest.databinding.FragmentPersonaBinding
import com.example.aztecatest.model.data.Personajes
import com.example.aztecatest.ui.state.PersonasStateEvent
import com.example.aztecatest.util.DataState
import com.example.aztecatest.viewmodel.PersonasViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PersonaFragment : Fragment(), ItemPersonaCallback {
    private lateinit var bindding: FragmentPersonaBinding
    private val personasViewModel by activityViewModels<PersonasViewModel>()

    private var adapter: PersonajesAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindding = FragmentPersonaBinding.inflate(inflater, container, false)
        return bindding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeObservers()
    }

    private fun subscribeObservers() {
        personasViewModel.personasResponse.observe(viewLifecycleOwner, {
            when (it) {
                is DataState.Loading -> {
                    Toast.makeText(context, "Cargando personajes", Toast.LENGTH_SHORT).show()
                }
                is DataState.Success -> {
                    //*AlertsNotifications().alertNormal(this.requireContext())
                    initRecyclerView(it.response.data!!)
                }
                is DataState.Error -> {
                    Log.e("AztecaTest", it.error.message!!)
                    Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()
                }
            }
        })
        personasViewModel.makeApicall(
            PersonasStateEvent.GetPersonajes
        )
    }

    private fun initRecyclerView(personasList: List<Personajes>) {
        adapter = PersonajesAdapter(personasList, this)
        bindding.gridView.layoutManager = GridLayoutManager(requireContext(), 4)
        bindding.gridView.adapter = adapter
    }

    override fun showDetailClicket(persona: Personajes) {
        val personasBundle = bundleOf("persona" to persona)
        view?.findNavController()?.navigate(R.id.detailsFragment, personasBundle)
    }
}