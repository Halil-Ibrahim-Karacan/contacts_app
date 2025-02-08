package com.example.contacts_app.ui.fragment

import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView.OnQueryTextListener

import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.contacts_app.R
import com.example.contacts_app.data.entity.Kisiler
import com.example.contacts_app.databinding.FragmentAnasayfaBinding
import com.example.contacts_app.ui.adapter.KisilerAdapter


class AnasayfaFragment : Fragment() {

    private lateinit var binding: FragmentAnasayfaBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding= FragmentAnasayfaBinding.inflate(inflater, container, false)

        binding.toolbarAnasayfa.title="Kişiler"

        binding.rw.layoutManager=LinearLayoutManager(requireContext())

        val kisilerListesi=ArrayList<Kisiler>()
        val k1=Kisiler(1,"Kenan","054449xxx")
        val k2=Kisiler(2,"Doru","0345xx4549x")
        val k3=Kisiler(3,"Levent","085046xx45")
        val k4=Kisiler(4,"Cenk","04465x88xx")
        kisilerListesi.add(k1)
        kisilerListesi.add(k2)
        kisilerListesi.add(k3)
        kisilerListesi.add(k4)


        val kisilerAdapter=KisilerAdapter(requireContext(),kisilerListesi)
        binding.rw.adapter=kisilerAdapter



        binding.fab.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.kayitgecis)

        }

        binding.searchView1.setOnQueryTextListener(object :OnQueryTextListener{
            override fun onQueryTextChange(newText: String): Boolean {
                ara(newText)
                return true

            }

            override fun onQueryTextSubmit(query: String): Boolean {
                ara(query)
                return true
            }
        })





        return binding.root

    }

    fun ara(arama_kelimesi:String){
        Log.e("Kişi Ara",arama_kelimesi)
    }


}