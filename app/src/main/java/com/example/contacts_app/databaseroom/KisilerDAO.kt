package com.example.contacts_app.databaseroom

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.contacts_app.data.entity.Kisiler

@Dao
interface KisilerDAO {
    @Query("SELECT * FROM contacts")
    suspend fun allContacts() : List<Kisiler>

    @Insert
    suspend fun add_Contact(contacts: Kisiler)

    @Update
    suspend fun update_Contact(contacts: Kisiler)

    @Delete
    suspend fun delete_Contact(contacts: Kisiler)

    @Query("SELECT * FROM contacts ORDER BY RANDOM() LIMIT :limit")
    suspend fun random_Limited_Contact(limit:Int) : List<Kisiler>

    @Query("SELECT * FROM contacts WHERE contact_name LIKE '%' || :search || '%' ")
    suspend fun search_Contact(search:String) : List<Kisiler>

    @Query("SELECT * FROM contacts WHERE contact_id=:id")
    suspend fun one_Contact(id:Int) : Kisiler

    @Query("SELECT count(*) FROM contacts WHERE contact_name=:name")
    suspend fun data_control_Contact(name:String) : Int
}