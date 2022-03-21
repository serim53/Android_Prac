package com.example.contactslistapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.contactslistapp.databinding.ItemContactBinding

class ContactAdapter(
    val contactItemClick: (Contact) -> Unit,
    val contactItemLongClick: (Contact) -> Unit
) : RecyclerView.Adapter<ContactAdapter.ViewHolder>() {

    private var contacts: List<Contact> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemContactBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(contacts[position])
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    inner class ViewHolder(
        private val binding: ItemContactBinding
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind(contact: Contact) {
            binding.contact = contact
            binding.root.setOnClickListener {
                contactItemClick(contact)
            }
            binding.root.setOnLongClickListener {
                contactItemLongClick(contact)
                true
            }
        }
    }

    fun setContacts(contacts: List<Contact>) {
        this.contacts = contacts
        notifyDataSetChanged()
    }
}