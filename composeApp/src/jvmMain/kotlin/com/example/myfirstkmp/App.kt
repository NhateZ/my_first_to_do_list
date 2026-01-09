package com.example.myfirstkmp

import androidx.compose.foundation.background

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
     val tasks = remember { mutableStateListOf<Task>() }

    tasks.addAll(listOf(
        Task(1,"Wash my belly!",false),
        Task(2,"My favorite task!",false),
        Task(3,"Clean my belly!",false)
    ))

    MaterialTheme(
        typography = MaterialTheme.typography.copy(
            bodySmall = MaterialTheme.typography.bodySmall.copy(
                fontFamily = FontFamily.SansSerif,
                color = Color.White
            )
        )
    ) {
        Column(
            modifier = Modifier
                .background(Color(99, 2, 252, 255))
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            Text("Input section", color = Color.White)// Input
            val newTaskText = remember { mutableStateOf("") }
            TextField(singleLine = true, value = newTaskText.value, onValueChange = { newTaskText.value = it })
            Row (
                modifier = Modifier
                    .padding(10.dp)
            ) {
                Button(
                    onClick = {
                        if (newTaskText.value.isNotEmpty()) {
                            tasks.add(Task(id = tasks.size + 1, text = newTaskText.value, isCompleted = false))
                        }
                        newTaskText.value = ""
                    }
                ) {
                    Text("Add Task!")
                }
                Spacer(modifier = Modifier.width(10.dp))
                Button(
                    onClick = {
                        tasks.removeIf { it.isCompleted }
                    }
                ) {
                    Text("Remove checked Tasks!")
                }
            }

            Text("Task list", color = Color.White)// Tasks list
            TaskList(
                tasks = tasks,
                onTaskCheckedChange = { task, checked ->
                    val index = tasks.indexOf(task)
                    if (index >= 0) {
                        tasks[index] = tasks[index].copy(isCompleted = checked)
                    }
                }
            )
        }
    }
}