package com.example.contacts_app.databaseroom

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.contacts_app.data.entity.Kisiler

//birden fazla tanımlamak için [Products::class, ..., ...], yani , ile ekleniyor
@Database(entities = [Kisiler::class], version = 1)

//asttact = interface özelliği olan class'tır
abstract class DatabaseContactRoom : RoomDatabase() {
    abstract  fun getKisilerDAO() : KisilerDAO
}