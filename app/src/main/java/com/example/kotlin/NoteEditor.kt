package com.example.kotlin

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.example.kotlin.data.Note

class NoteEditor(
    private val note: Note? = null
): DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity.let {
            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater
            val view = inflater.inflate(R.layout.note_editor, null)
            val editTitle: EditText = view.findViewById(R.id.editNoteTitle)
            val editDescription: EditText = view.findViewById(R.id.editNoteDescription)

            if (note != null) {
                editTitle.setText(note.getTitle())
                editDescription.setText(note.getDescription())
            }

            builder.setView(view)
                .setPositiveButton("Save") { dialog, id ->
                    if (note != null) {
                        (activity as MainActivity).editNote(
                            note,
                            editTitle.text.toString(),
                            editDescription.text.toString()
                        )
                    } else {
                        (activity as MainActivity).addNote(
                            editTitle.text.toString(),
                            editDescription.text.toString()
                        )
                    }
                }
                .setNegativeButton("Cancel") { dialog, id ->
                    println("Cancel button clicked")
                }
                .setTitle("New note")

            builder.create()
        }
    }

}