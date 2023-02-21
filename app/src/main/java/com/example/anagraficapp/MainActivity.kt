package com.example.anagraficapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.anagraficapp.adapters.PersonAdapter
import com.example.anagraficapp.dao.PersonsDatabase
import com.example.anagraficapp.services.PersonService
import java.util.concurrent.Executors

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inizializzo il database
        val db = Room.databaseBuilder(
            this@MainActivity,
            PersonsDatabase::class.java,
            "anagrafica"
        ).build()
        // Inizializzo il Dao
        val personDao = db.getPersonDao()

        // Dichiaro il layout da utilizzare nella RecyclerView
        findViewById<RecyclerView>(R.id.list_persons).apply {
            layoutManager =
                LinearLayoutManager(context).apply { orientation = RecyclerView.VERTICAL }
        }
        PersonService.setDao(personDao)
    }

    override fun onResume() {
        super.onResume()
        Log.d("MainActivity", "onResume()")
        // Inizializzo nuovamente il database e riempio di elementi la RecyclerView
        findViewById<RecyclerView>(R.id.list_persons).apply {
            Executors.newSingleThreadExecutor().execute {
                val data = Room.databaseBuilder(
                    this@MainActivity,
                    PersonsDatabase::class.java,
                    "anagrafica"
                ).build().getPersonDao().getAll()
                // Ritorno sull'UI Thread per evitare l'errore nella view
                runOnUiThread {
                    adapter = PersonAdapter(data) {
                        Executors.newSingleThreadExecutor().execute {
                            //Funzione di callback che rimuove il dato
                            PersonService.removePerson(it)
                        }
                    }
                }
            }
        }

        // Richiamo l'activity che si occupa della creazione di una nuova persona
        findViewById<Button>(R.id.new_person_button).setOnClickListener {
            val intent = Intent(this@MainActivity, NewPersonActivity::class.java)
            startActivity(intent)
        }
    }
}

