package com.example.contacts_app.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.contacts_app.data.entity.Kisiler
import com.example.contacts_app.repo.KisiDAORepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class KisiDAOViewModel @Inject constructor(var kisiDAORepository: KisiDAORepository) : ViewModel(){

    var kisilerListesi: MutableLiveData<List<Kisiler>>

    init {
        kisileriYukle()
        kisilerListesi = kisiDAORepository.KisileriGetir()
    }

    fun kisileriYukle() {
        kisiDAORepository.tumKisiler()
    }

    fun kisiEkle(kisiAd: String, kisiTel: String) {
            //id veritabanında otomatik arrtığı için, burda girilen değer farketmez
        kisiDAORepository.kisiEkle(kisiAd, kisiTel)
    }

    fun kisiGuncelle(kisiId: Int, kisiAd: String, kisiTel: String) {
        kisiDAORepository.kisiGuncelle(kisiId, kisiAd, kisiTel)
    }

    fun kisiSil(kisi: Kisiler) {
        kisiDAORepository.kisiSil(kisi)
    }
}