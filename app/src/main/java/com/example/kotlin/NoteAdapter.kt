package com.example.kotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.data.Note

class NoteAdapter(
    private val dataSet: ArrayList<Note>,
    private val manager: FragmentManager
): RecyclerView.Adapter<NoteAdapter.ViewHolder>() {


    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val title: TextView
        private val subtitle: TextView
        private val editBtn: ImageButton
        private val deleteBtn: ImageButton

        fun getTitle(): TextView {
            return this.title
        }

        fun getSubtitle(): TextView {
            return this.subtitle
        }

        fun getEditBtn(): ImageButton {
            return this.editBtn
        }

        fun getDeleteBtn(): ImageButton {
            return this.deleteBtn
        }


        init {
            title = view.findViewById(R.id.title)
            subtitle = view.findViewById(R.id.subtitle)
            editBtn = view.findViewById(R.id.editBtn)
            deleteBtn = view.findViewById(R.id.deleteBtn)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.note_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val note: Note = dataSet[position]

        holder.getTitle().text = note.getTitle()
        holder.getSubtitle().text = note.getDescription()

        holder.getEditBtn().setOnClickListener {
            NoteEditor(note).show(manager, "NoteEditor")
        }
        holder.getDeleteBtn().setOnClickListener {
            dataSet.removeAt(position)
            notifyItemRemoved(position)
        }
    }



    override fun getItemCount(): Int = dataSet.size
}