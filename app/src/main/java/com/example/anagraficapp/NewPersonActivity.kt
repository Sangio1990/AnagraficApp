package com.example.anagraficapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
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
                if (findViewById<RadioButton>(R.id.male_radioButton).isChecked) {
                    "M"
                } else if (findViewById<RadioButton>(R.id.female_radioButton).isChecked) {
                    "F"
                } else
                    "U"
            )
            // Piccolo controllo che impedisce di salvare un dato con uno dei campi vuoti
            if (person.name == "" ||
                person.surname == "" ||
                person.birthday == "" ||
                person.birthcity == "" ||
                person.province == "" ||
                person.gender == "U"
            ) {
                // Se un campo è vuoto mando un piccolo messaggio di errore all'utente
                Toast.makeText(applicationContext, "Devi riempire tutti i campi", Toast.LENGTH_LONG)
                    .show()
            } else {
                Executors.newSingleThreadExecutor().execute {
                    PersonService.addPerson(person)
                }
                // Chiudo la view
                finish()
            }
        }


    }
}