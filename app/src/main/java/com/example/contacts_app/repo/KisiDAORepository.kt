package com.example.contacts_app.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.contacts_app.data.entity.Kisiler
import com.example.contacts_app.databaseroom.KisilerDAO
import com.example.contacts_app.ui.adapter.KisilerAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class KisiDAORepository(var kisilerDAO: KisilerDAO) {
    var kisilerListesi: MutableLiveData<List<Kisiler>>

    init {
        kisilerListesi = MutableLiveData()
    }

    fun KisileriGetir(): MutableLiveData<List<Kisiler>> {

        return kisilerListesi
    }

    fun tumKisiler() {
        val job = CoroutineScope(Dispatchers.Main).launch {
            kisilerListesi.value = kisilerDAO.allContacts()
        }
    }

    fun kisiEkle(kisiAd: String, kisiTel: String) {
        val job = CoroutineScope(Dispatchers.Main).launch {
            //id veritabanında otomatik arrtığı için, burda girilen değer farketmez
            kisilerDAO.add_Contact(Kisiler(0, kisiAd, kisiTel))
        }
    }

    fun kisiGuncelle(kisiId: Int, kisiAd: String, kisiTel: String) {
        val job = CoroutineScope(Dispatchers.Main).launch {
            kisilerDAO.update_Contact(Kisiler(kisiId, kisiAd, kisiTel))
        }
    }

    fun kisiSil(kisi: Kisiler) {
        val job = CoroutineScope(Dispatchers.Main).launch {
            kisilerDAO.delete_Contact(kisi)
            tumKisiler()
        }
    }

    fun kisiAra(kisiAd: String) {
        val job = CoroutineScope(Dispatchers.Main).launch {
            kisilerListesi.value = kisilerDAO.search_Contact(kisiAd)
        }
    }

}