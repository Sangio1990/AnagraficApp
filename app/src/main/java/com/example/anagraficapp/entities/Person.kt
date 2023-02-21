package com.example.anagraficapp.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

/*
Attributes needed
Nome: String
Cognome: String
Data di nascita: String
Città di Nascita: String
Provincia di Nascita: String
Sesso: String
 */

@Entity(tableName = "persons")
data class Person(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val name: String,
    val surname: String,
    val birthday: String,
    val birthcity: String,
    val province: String,
    val gender: String
){
    constructor() : this(0, "", "", "", "", "", "")
}