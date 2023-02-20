package com.example.anagraficapp.entities

import java.util.Date

/*
Attributes needed
Nome: String
Cognome: String
Data di nascita: String
Città di Nascita: String
Provincia di Nascita: String
Sesso: String
 */

data class Person(val id: Long, val name: String, val surname: String, val birthday: String, val birthcity: String, val province: String, val gender: String){
}
