package com.example.anagraficapp.services
import com.example.anagraficapp.dao.PersonDao
import com.example.anagraficapp.entities.Person

object PersonService : IPersonService {
    private lateinit var dao: PersonDao
    fun setDao(input_dao: PersonDao) {
        dao = input_dao
    }

    fun getDao() = dao


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