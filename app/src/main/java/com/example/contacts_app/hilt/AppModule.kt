package com.example.contacts_app.hilt

import android.content.Context
import androidx.room.Room
import com.example.contacts_app.databaseroom.DatabaseContactRoom
import com.example.contacts_app.databaseroom.KisilerDAO
import com.example.contacts_app.repo.KisiDAORepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideKisilerDAORepository(kisilerDAO: KisilerDAO): KisiDAORepository{
        return KisiDAORepository(kisilerDAO)
    }

    @Provides
    @Singleton
    fun provideKisilerDAO(@ApplicationContext context: Context): KisilerDAO{
        val db = Room.databaseBuilder(context.applicationContext, DatabaseContactRoom::class.java,"contacts_app.sqlite").createFromAsset("contacts_app.sqlite").build()
        return db.getKisilerDAO()
    }
}