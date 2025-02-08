package com.example.contacts_app.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.contacts_app.R
import com.example.contacts_app.databinding.FragmentKayitBinding

class KayitFragment : Fragment() {
    private lateinit var binding: FragmentKayitBinding



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding= FragmentKayitBinding.inflate(inflater, container, false)

        binding.toolbarKayit.title="Kişi Kayıt"
        binding.buttonKayit.setOnClickListener {
            val kisi_ad=binding.edittextkisiAd.text.toString()
            val tel_no=binding.edittextKisiTel.text.toString()
            kaydet(kisi_ad,tel_no)


        }


        return binding.root

    }

    fun kaydet(kisi_ad:String,tel_no:String){
        Log.e("kisi kaydet ","$kisi_ad - $tel_no")

    }


}