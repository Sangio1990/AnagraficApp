package com.example.anagraficapp.services

import com.example.anagraficapp.entities.Person
import java.util.*

class PersonService : IPersonService {
    companion object{
        val personList: MutableList<Person> = mutableListOf(
            Person(1, "Mario", "rossi", "01/01/1965","Milano", "MI", "M"),
            Person(2, "Lucia", "Bianchi", "12/05/1987", "Torino", "TO", "F"),
            Person(3, "Luigi", "Mario", "06/11/1983 ", "Venezia", "VE", "M")
        )
    }

    override fun addPerson(person: Person){
        personList.add(person)
    }

    override fun removePerson(person: Person){
        personList.remove(person)
    }

    override fun getAllPersons(): List<Person> = personList

}