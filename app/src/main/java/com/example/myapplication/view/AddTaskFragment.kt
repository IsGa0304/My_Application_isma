package com.example.myapplication.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.myapplication.R
import com.example.myapplication.controller.TaskController

class AddTaskFragment(private val taskController: TaskController) : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add_task, container, false)
        val titleEditText = view.findViewById<EditText>(R.id.editTextTitle)
        val descriptionEditText = view.findViewById<EditText>(R.id.editTextDescription)
        val addButton = view.findViewById<Button>(R.id.buttonSaveTask)

        addButton.setOnClickListener {
            val title = titleEditText.text.toString()
            val description = descriptionEditText.text.toString()
            if (title.isNotBlank() && description.isNotBlank()) {
                taskController.addTask(title, description)
                dismiss()
            } else {
                Toast.makeText(context, "Por favor ingrese título y descripción", Toast.LENGTH_SHORT).show()
            }
        }
        return view
    }
}