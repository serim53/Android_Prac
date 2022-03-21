package com.example.contactslistapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.contactslistapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var contactViewModel: ContactViewModel
    lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        val adapter = ContactAdapter({ contact ->
            intent.putExtra(AddActivity.EXTRA_CONTACT_NAME, contact.name)
            intent.putExtra(AddActivity.EXTRA_CONTACT_NUMBER, contact.number)
            intent.putExtra(AddActivity.EXTRA_CONTACT_ID, contact.id)
            startActivity(intent)
        }, { contact ->
            deleteDialog(contact)
        })

        val lm = LinearLayoutManager(this)
        mainBinding.recyclerview.adapter = adapter
        mainBinding.recyclerview.layoutManager = lm
        mainBinding.recyclerview.setHasFixedSize(true)

        contactViewModel = ViewModelProvider(this).get(ContactViewModel::class.java)
        contactViewModel.getAll().observe(this, Observer<List<Contact>> { contacts ->
                adapter.setContacts(contacts!!)
        })

        mainBinding.btnMain.setOnClickListener {
            val intent = Intent(this, AddActivity::class.java)
            startActivity(intent)
        }
    }

    private fun deleteDialog(contact: Contact) {
        val builder = AlertDialog.Builder(this)
        builder.setMessage("Delete selected contact?")
            .setNegativeButton("NO") { _, _ -> }
            .setPositiveButton("YES") { _, _ ->
                contactViewModel.delete(contact)
            }
        builder.show()
    }
}