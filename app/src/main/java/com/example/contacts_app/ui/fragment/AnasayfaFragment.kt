package com.example.contacts_app.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView.OnQueryTextListener
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope

import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.contacts_app.R
import com.example.contacts_app.data.entity.Kisiler
import com.example.contacts_app.databaseroom.KisilerDAO
import com.example.contacts_app.databaseroom.DatabaseContactRoom
import com.example.contacts_app.databinding.FragmentAnasayfaBinding
import com.example.contacts_app.ui.adapter.KisilerAdapter
import com.example.contacts_app.viewmodel.KisiDAOViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.Locale


@AndroidEntryPoint
class AnasayfaFragment : Fragment() {

    private lateinit var binding: FragmentAnasayfaBinding
    private var kisilerListesi: ArrayList<Kisiler>? = null
    private lateinit var kisilerAdapter: KisilerAdapter
    private lateinit var viewModel: KisiDAOViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: KisiDAOViewModel by viewModels()
        this.viewModel = tempViewModel
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding= DataBindingUtil.inflate(inflater, R.layout.fragment_anasayfa, container, false)


        viewModel.kisilerListesi.observe(viewLifecycleOwner){
            kisilerAdapter = KisilerAdapter(requireContext(), it as MutableList<Kisiler>,viewModel)
            binding.adapter = kisilerAdapter
        }

        binding.fab.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.kayitgecis)

        }

        binding.searchView1.setOnQueryTextListener(object :OnQueryTextListener{
            override fun onQueryTextChange(newText: String): Boolean {
                viewModel.kisiAra(newText)
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                viewModel.kisiAra(query)
                return true
            }
        })

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        viewModel.kisileriYukle()
    }

}