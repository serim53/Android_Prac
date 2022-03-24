package com.example.contactslistapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.contactslistapp.databinding.ActivityAddBinding

class AddActivity :AppCompatActivity() {

    private lateinit var contactViewModel: ContactViewModel
    private var id: Long? = null
    lateinit var addBinding: ActivityAddBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addBinding = ActivityAddBinding.inflate(layoutInflater)
        setContentView(addBinding.root)

        contactViewModel = ViewModelProvider(this)[ContactViewModel::class.java]

        // intent null check & get extras
        if (intent != null && intent.hasExtra(EXTRA_CONTACT_NAME)
            && intent.hasExtra(EXTRA_CONTACT_NUMBER) && intent.hasExtra(EXTRA_CONTACT_ID)) {
            addBinding.etAddName.setText(intent.getStringExtra(EXTRA_CONTACT_NAME))
            addBinding.etAddNumber.setText(intent.getStringExtra(EXTRA_CONTACT_NUMBER))
            id = intent.getLongExtra(EXTRA_CONTACT_ID, -1)
        }

        addBinding.btnAdd.setOnClickListener {
            val name = addBinding.etAddName.text.toString().trim()
            val number = addBinding.etAddNumber.text.toString()

            if (name.isEmpty() || number.isEmpty()) {
                Toast.makeText(this, "Please enter name and number.", Toast.LENGTH_SHORT).show()
            } else {
                val initial = name[0].uppercaseChar()
                val contact = Contact(id, name, number, initial)
                contactViewModel.insert(contact)
                finish()
            }
        }
    }

    companion object {
        const val EXTRA_CONTACT_NAME = "EXTRA_CONTACT_NAME"
        const val EXTRA_CONTACT_NUMBER = "EXTRA_CONTACT_NUMBER"
        const val EXTRA_CONTACT_ID = "EXTRA_CONTACT_ID"
    }
}