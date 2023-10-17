package com.example.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.data.Note
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    // Elements
    private lateinit var fab: FloatingActionButton
    private val notes: ArrayList<Note> = ArrayList()
    private val noteAdapter = NoteAdapter(notes, supportFragmentManager)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fab = findViewById(R.id.floatingActionButton)
        fab.setOnClickListener {
            NoteEditor().show(supportFragmentManager, "noteEditor")
        }

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = noteAdapter
    }
    fun addNote(title: String, description: String) {
        notes.add(Note(
            title,
            description
        ))
        noteAdapter.notifyItemInserted(notes.size - 1)
    }

    fun editNote(note: Note, title: String, description: String) {
        val index = notes.indexOf(note)
        notes[index].setTitle(title)
        notes[index].setDescription(description)
        noteAdapter.notifyItemChanged(index)
    }
}