package com.example.contacts_app.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.example.contacts_app.data.entity.Kisiler
import com.example.contacts_app.databinding.CardViewBinding
import com.example.contacts_app.databinding.FragmentAnasayfaBinding
import com.example.contacts_app.ui.fragment.AnasayfaFragmentDirections
import com.google.android.material.snackbar.Snackbar

class KisilerAdapter(var mContext:Context ,var kisiler_Listesi:List<Kisiler>) :RecyclerView.Adapter<KisilerAdapter.CardTasarimHolder>() {


    inner class CardTasarimHolder(var tasarim: CardViewBinding):RecyclerView.ViewHolder(tasarim.root)




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimHolder {
        val binding= CardViewBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return CardTasarimHolder(binding)
    }


    override fun onBindViewHolder(holder: CardTasarimHolder, position: Int) {
       val kisi=kisiler_Listesi.get(position)
        val t=holder.tasarim

        t.textViewName.text=kisi.kisi_ad
        t.textViewPNumber.text=kisi.kisi_tel

        t.CardviewSatir.setOnClickListener {
            val gecis=AnasayfaFragmentDirections.detaygecis(kisi)
            Navigation.findNavController(it).navigate(gecis)

        }

        t.imageViewCancel.setOnClickListener {
            Snackbar.make(it,"${kisi.kisi_ad} silinsin mi ?",Snackbar.LENGTH_SHORT)
                .setAction("Evet"){
                    sil(kisi.kisi_id)

                }
                .show()
        }

    }



    override fun getItemCount(): Int {
        return kisiler_Listesi.size
    }




    fun sil(kisi_id:Int){
        Log.e("Kişi Sildindi",kisi_id.toString())

    }


}