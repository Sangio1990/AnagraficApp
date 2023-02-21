package com.example.anagraficapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import androidx.room.Room
import com.example.anagraficapp.entities.Person
import com.example.anagraficapp.services.PersonService
import java.util.concurrent.Executors

/**
 * View specializzata nell'inserimento di un nuovo elemento di tipo Person da parte dell'utente
 */
class NewPersonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_person)

        findViewById<Button>(R.id.save_button).setOnClickListener {
            val person = Person(
                // Creo un nuovo oggetto Person prendendo i dati dai campi della textView
                0,
                findViewById<EditText>(R.id.edit_text_name).text.toString(),
                findViewById<EditText>(R.id.edit_text_surname).text.toString(),
                findViewById<EditText>(R.id.edit_text_birthday).text.toString(),
                findViewById<EditText>(R.id.edit_text_birthplace).text.toString(),
                findViewById<EditText>(R.id.edit_text_province).text.toString(),
                if (findViewById<RadioButton>(R.id.male_radioButton).isActivated) {
                    "M"
                } else {
                    "F"
                }
            )
            Executors.newSingleThreadExecutor().execute {
                PersonService.addPerson(person)
            }
            Log.d("NewPersonActivity", "${person.name}, ${person.surname}, ${person.gender}")
            finish()
        }


    }
}