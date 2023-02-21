package com.example.anagraficapp.services

import com.example.anagraficapp.dao.PersonDao
import com.example.anagraficapp.entities.Person

/**
 * Creo un Object, in modo che non possa essere instanziato più volte, a cui assegno poi il Dao
 * Questo Object deve gestire l'inserimento e l'eliminazione di un elemento dal database
 */
object PersonService : IPersonService {
    private lateinit var dao: PersonDao

    /**
     * Funzione che setta il Dao all'interno del PersonService
     */
    fun setDao(input_dao: PersonDao) {
        dao = input_dao
    }

    override fun addPerson(person: Person) {
        dao.save(person)
    }

    override fun removePerson(person: Person) {
        dao.delete(person)
    }

    fun removePerson(id: Long) {
        dao.delete(getAllPersons().first { p -> p.id == id })
    }

    override fun getAllPersons(): List<Person> {
        return dao.getAll()
    }


}