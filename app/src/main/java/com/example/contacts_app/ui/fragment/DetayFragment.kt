package com.example.contacts_app.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.contacts_app.R
import com.example.contacts_app.databinding.FragmentDetayBinding


class DetayFragment : Fragment() {
    private lateinit var binding: FragmentDetayBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding= FragmentDetayBinding.inflate(inflater, container, false)

        binding.toolbarDetay.title="Kişi Detay"

        val bundle:DetayFragmentArgs by navArgs()
        val gelen_kisi=bundle.kisi

        binding.edittextkisiAd.setText(gelen_kisi.kisi_ad)
        binding.edittextKisiTel.setText(gelen_kisi.kisi_tel)

        binding.buttonGuncell.setOnClickListener {
            val kisi_ad=binding.edittextkisiAd.text.toString()
            val kisi_tel=binding.edittextKisiTel.text.toString()
            guncelle(gelen_kisi.kisi_id,kisi_ad,kisi_tel)

        }



        return binding.root

    }
    fun guncelle(kisi_id:Int,kisi_ad:String,tel_no:String){
        Log.e("kisi Güncelle ","$kisi_id- $kisi_ad - $tel_no")

    }


}