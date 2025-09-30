package com.example.contacts_app.ui.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.contacts_app.R
import com.example.contacts_app.data.entity.Kisiler
import com.example.contacts_app.databaseroom.KisilerDAO
import com.example.contacts_app.databaseroom.DatabaseContactRoom
import com.example.contacts_app.databinding.CardViewBinding
import com.example.contacts_app.ui.fragment.AnasayfaFragmentDirections
import com.example.contacts_app.viewmodel.KisiDAOViewModel
import com.google.android.material.snackbar.Snackbar

class KisilerAdapter(var mContext:Context ,var kisiler_Listesi:MutableList<Kisiler>, val viewModel: KisiDAOViewModel) :RecyclerView.Adapter<KisilerAdapter.CardTasarimHolder>() {


    inner class CardTasarimHolder(var tasarim: CardViewBinding):RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimHolder {
        val binding= DataBindingUtil.inflate<CardViewBinding>(LayoutInflater.from(parent.context), R.layout.card_view, parent, false)
        return CardTasarimHolder(binding)
    }


    override fun onBindViewHolder(holder: CardTasarimHolder, position: Int) {
       val kisi=kisiler_Listesi.get(position)
        val t=holder.tasarim

        t.kisi = kisi

        //t.textViewName.text=kisi.kisi_ad
        //t.textViewPNumber.text=kisi.kisi_telefon

        t.CardviewSatir.setOnClickListener {
            val gecis=AnasayfaFragmentDirections.detaygecis(kisi)
            Navigation.findNavController(it).navigate(gecis)

        }

        t.imageViewCancel.setOnClickListener {
            Snackbar.make(it,"${kisi.kisi_ad} silinsin mi ?",Snackbar.LENGTH_SHORT)
                .setAction("Evet"){
                    viewModel.kisiSil(kisi)
                    viewModel.kisileriYukle()
                }
                .show()
        }

    }



    override fun getItemCount(): Int {
        return kisiler_Listesi.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(newList: ArrayList<Kisiler?>) {
        kisiler_Listesi = newList as MutableList<Kisiler>
        notifyDataSetChanged()
    }




}