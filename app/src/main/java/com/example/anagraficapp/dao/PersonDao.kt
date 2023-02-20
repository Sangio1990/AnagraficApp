package com.example.anagraficapp.dao

import com.example.anagraficapp.entities.Person

interface PersonDao {
    /**
     * Salvare una persona sul database.
     */
    fun save(person: Person)

    /**
     * Recuperare le persone
     * @return le persone salvate nel database.
     */
    fun getAll(): List<Person>
}