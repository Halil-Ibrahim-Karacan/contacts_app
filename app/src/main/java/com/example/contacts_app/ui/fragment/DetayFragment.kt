package com.example.contacts_app.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.contacts_app.R
import com.example.contacts_app.data.entity.Kisiler
import com.example.contacts_app.databaseroom.KisilerDAO
import com.example.contacts_app.databaseroom.DatabaseContactRoom
import com.example.contacts_app.databinding.FragmentDetayBinding
import com.example.contacts_app.viewmodel.KisiDAOViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetayFragment : Fragment() {
    private lateinit var binding: FragmentDetayBinding
    private var gelen_kisi: Kisiler? = null
    private lateinit var viewModel: KisiDAOViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: KisiDAOViewModel by viewModels()
        this.viewModel = tempViewModel
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding= FragmentDetayBinding.inflate(inflater, container, false)

        val bundle:DetayFragmentArgs by navArgs()
        gelen_kisi=bundle.kisi

        binding.edittextkisiAdDetay.setText(gelen_kisi?.kisi_ad)
        binding.edittextKisiTelDetay.setText(gelen_kisi?.kisi_telefon)

        binding.buttonGuncelle.setOnClickListener {
            val kisi_id = gelen_kisi?.kisi_id
            val kisi_ad=binding.edittextkisiAdDetay.text.toString()
            val kisi_tel=binding.edittextKisiTelDetay.text.toString()
            viewModel.kisiGuncelle(kisi_id!!, kisi_ad, kisi_tel)
            Navigation.findNavController(it).navigate(R.id.detaydanAnasayfayagecis)
        }
        return binding.root

    }

}