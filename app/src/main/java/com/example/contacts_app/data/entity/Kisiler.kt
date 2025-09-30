package com.example.contacts_app.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.io.Serializable

@Entity("contacts")
data class Kisiler(@PrimaryKey(autoGenerate = true)
                   @ColumnInfo(name = "contact_id") @NotNull var kisi_id:Int,
                   @ColumnInfo(name = "contact_name") @NotNull var kisi_ad:String,
                   @ColumnInfo(name = "contact_phone") @NotNull var kisi_telefon:String):Serializable {

}