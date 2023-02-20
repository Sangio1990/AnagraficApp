package com.example.anagraficapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.anagraficapp.adapters.PersonAdapter
import com.example.anagraficapp.services.PersonService

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val perServ = PersonService()
        val myAdapter = PersonAdapter(perServ.getAllPersons()) {
            findViewById<RecyclerView>(R.id.list_persons).adapter?.notifyDataSetChanged()
        }

        // Inizializzo e riempio di elementi la RecyclerView
        findViewById<RecyclerView>(R.id.list_persons).apply {
            adapter = myAdapter
            layoutManager = LinearLayoutManager(context)

        }

        // Richiamo l'activity che si occupa della creazione di una nuova persona
        findViewById<Button>(R.id.new_person_button).setOnClickListener {
            val intent = Intent(this, NewPersonActivity::class.java)
            this.startActivity(intent)
        }
    }
}
