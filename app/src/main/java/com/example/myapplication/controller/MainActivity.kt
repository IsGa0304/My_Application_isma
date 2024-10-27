package com.example.myapplication.controller

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.model.Task
import com.example.myapplication.view.AddTaskFragment
import com.example.myapplication.view.TaskAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var taskAdapter: TaskAdapter
    private lateinit var taskController: TaskController
    private val taskList = mutableListOf<Task>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerViewTasks)
        recyclerView.layoutManager = LinearLayoutManager(this)

        taskAdapter = TaskAdapter(taskList) { task, action ->
            when (action) {
                "complete" -> taskController.markTaskAsCompleted(task)
                "delete" -> taskController.deleteTask(task)
            }
        }

        taskController = TaskController(taskList, taskAdapter)
        recyclerView.adapter = taskAdapter

        findViewById<Button>(R.id.buttonAddTask).setOnClickListener {
            openAddTaskFragment()
        }
    }

    private fun openAddTaskFragment() {
        val fragment = AddTaskFragment(taskController)
        fragment.show(supportFragmentManager, "AddTaskFragment")
    }
}