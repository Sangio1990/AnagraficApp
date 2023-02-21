package com.example.anagraficapp.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.anagraficapp.entities.Person

/**
 * Classe Astratta che rappresenta il database anagrafica
 *
 */
@Database(
    version = PersonsDatabase.VERSION,
    entities = [Person::class]
)
abstract class PersonsDatabase : RoomDatabase() {
    companion object {
        const val VERSION = 1
        const val DATABASE_NAME =
            "anagrafica" // non utilizzato per ora ma sicuramente utile in futuro
    }

    abstract fun getPersonDao(): DatabasePersonsDao

}