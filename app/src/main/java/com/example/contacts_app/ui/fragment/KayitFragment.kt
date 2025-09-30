package com.example.contacts_app.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.contacts_app.R
import com.example.contacts_app.data.entity.Kisiler
import com.example.contacts_app.databaseroom.KisilerDAO
import com.example.contacts_app.databaseroom.DatabaseContactRoom
import com.example.contacts_app.databinding.FragmentKayitBinding
import com.example.contacts_app.viewmodel.KisiDAOViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.getValue

@AndroidEntryPoint
class KayitFragment : Fragment() {
    private lateinit var binding: FragmentKayitBinding
    private lateinit var viewModel: KisiDAOViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: KisiDAOViewModel by viewModels()
        this.viewModel = tempViewModel
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding= FragmentKayitBinding.inflate(inflater, container, false)

        binding.buttonKayit.setOnClickListener {
            val kisi_ad=binding.edittextkisiAdKayit.text.toString()
            val tel_no=binding.edittextKisiTelKayit.text.toString()
            viewModel.kisiEkle(kisi_ad, tel_no)
            Navigation.findNavController(it).navigate(R.id.kayittanAnasayfayagecis)
        }


        return binding.root

    }




}