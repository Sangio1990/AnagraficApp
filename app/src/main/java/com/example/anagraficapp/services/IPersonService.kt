package com.example.anagraficapp.services

import com.example.anagraficapp.entities.Person

/**
 * Service che si occupa della gestione dei dati relativi alle persone
 */

interface IPersonService {
    /**
     * Funzione che si occupa dell'aggiunta di una persona
     * @param person: Person
     * @return Unit
     */
    fun addPerson(person: Person): Unit

    /**
     * Funzione che si occupa della rimozione di una persona
     * @param person: Person
     * @return Unit
     */
    fun removePerson(person: Person): Unit

    /**
     * Funzione che si occupa di ritornare tutte le persone salvate in una lista
     * @return List<Person>
     */
    fun getAllPersons(): List<Person>
}