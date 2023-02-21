package com.example.anagraficapp.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.anagraficapp.entities.Person

@Database(
    version = PersonsDatabase.VERSION,
    entities = [Person::class]
)
abstract class PersonsDatabase : RoomDatabase() {
    companion object {
        const val VERSION = 1
        const val DATABASE_NAME = "persons"

        @Volatile
        private var INSTANCE: PersonsDatabase? = null

        fun getDatabase(context: Context): PersonsDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            val instance = Room.databaseBuilder(
                context.applicationContext,
                PersonsDatabase::class.java,
                "anagrafica"
            ).build()
            INSTANCE = instance
            return instance
        }

    }

    abstract fun getPersonDao(): DatabasePersonsDao

}