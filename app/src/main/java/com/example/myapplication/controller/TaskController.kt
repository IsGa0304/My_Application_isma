package com.example.myapplication.controller

import com.example.myapplication.model.Task
import com.example.myapplication.view.TaskAdapter

class TaskController(
    private val taskList: MutableList<Task>,
    private val taskAdapter: TaskAdapter
) {
    private var nextId = 1

    fun addTask(title: String, description: String) {
        val newTask = Task(id = nextId++, title = title, description = description)
        taskList.add(newTask)
        taskAdapter.notifyDataSetChanged()
    }

    fun markTaskAsCompleted(task: Task) {
        task.completed = true
        taskAdapter.notifyDataSetChanged()
    }

    fun deleteTask(task: Task) {
        taskList.remove(task)
        taskAdapter.notifyDataSetChanged()
    }
}