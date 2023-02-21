package com.example.anagraficapp.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.anagraficapp.R
import com.example.anagraficapp.entities.Person
import com.example.anagraficapp.services.PersonService
import java.util.*
import java.util.concurrent.Executors

/**
 * Adapter il cui compito è quello di gestire la visualizzazione dei dati nella RecyclerView in nella MainActivity
 * @param personList: List<Person>  ->  Lista di persone
 * @return viewHolder: View -> La view da mostrare
 */
class PersonAdapter(val personList: List<Person>, private val callback: (Long) -> Unit) :
    RecyclerView.Adapter<PersonAdapter.viewHolder>() {
    class viewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameTextView: TextView = view.findViewById(R.id.text_view_person_name)
        val birthdayTextView: TextView = view.findViewById(R.id.text_view_person_birthday)
        val provinceTextView: TextView = view.findViewById(R.id.text_view_birthplace)
        val delButton: Button = view.findViewById(R.id.delete_person_button)

    }

    /**
     * Metodo che crea una ViewHolder adatto ai dati passati
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.person_list_item, parent, false)
        return viewHolder(view)
    }

    /**
     * @return Int -> Numero di elementi da presentare
     */
    override fun getItemCount(): Int = personList.size


    /**
     * Metodo che ha il compito di presentare UN singolo dato
     * @param position -> Posizione dell'elemento nella lista
     * @param holder -> Il ViewHolder preparato da onCreateViewHolder
     */
    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val person = personList[position]
        // Rendo il primo carattere del nome e del cognome in uppercase
        val fullName = "${
            person.name.lowercase().replaceFirstChar {
                if (it.isLowerCase()) it.titlecase(
                    Locale.ROOT
                ) else it.toString()
            }
        } ${
            person.surname.lowercase().replaceFirstChar {
                if (it.isLowerCase()) it.titlecase(
                    Locale.ROOT
                ) else it.toString()
            }
        }"
        val fullBirthplace = "${person.birthcity} (${person.province})"
        holder.nameTextView.text = fullName
        holder.birthdayTextView.text = person.birthday
        holder.provinceTextView.text = fullBirthplace


        // Setto l'azione che il bottone DEL deve eseguire
        holder.delButton.setOnClickListener {
            // Richiamo la funzione di callback che forza la view ad aggiornarsi.
            callback(person.id)
        }
    }

}