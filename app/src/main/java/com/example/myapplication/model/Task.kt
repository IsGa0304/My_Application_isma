package com.example.myapplication.model

data class Task(
    val id: Int,
    var title: String,
    var description: String,
    var completed: Boolean = false
)
