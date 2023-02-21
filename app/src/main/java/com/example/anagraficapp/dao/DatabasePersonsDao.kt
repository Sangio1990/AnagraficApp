package com.example.anagraficapp.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.anagraficapp.entities.Person

@Dao
interface DatabasePersonsDao: PersonDao {
    @Query("SELECT * FROM persons")
    override fun getAll(): List<Person>

    @Insert
    override fun save(person: Person)

    @Delete
    override fun delete(person: Person)
}