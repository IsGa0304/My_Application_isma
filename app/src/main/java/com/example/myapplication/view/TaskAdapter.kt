package com.example.myapplication.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.model.Task

class TaskAdapter(
    private var tasks: List<Task>,
    private val onAction: (Task, String) -> Unit
) : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false)
        return TaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = tasks[position]
        holder.bind(task)
    }

    override fun getItemCount(): Int = tasks.size

    inner class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView: TextView = itemView.findViewById(R.id.textViewTaskTitle)
        private val completeCheckBox: CheckBox = itemView.findViewById(R.id.checkBoxComplete)
        private val deleteButton: Button = itemView.findViewById(R.id.buttonDeleteTask)

        fun bind(task: Task) {
            titleTextView.text = task.title
            completeCheckBox.isChecked = task.completed
            completeCheckBox.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) onAction(task, "complete")
            }
            deleteButton.setOnClickListener { onAction(task, "delete") }
        }
    }
}