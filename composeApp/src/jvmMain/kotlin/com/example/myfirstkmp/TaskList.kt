package com.example.myfirstkmp

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.* // or material.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.items

@Composable
fun TaskList(tasks: List<Task>, onTaskCheckedChange: (Task, Boolean) -> Unit) {
    LazyColumn (
        modifier = Modifier
            .fillMaxWidth()
    ) {
        items(tasks) {
            task ->
            TaskItem(
                task = task,
                onCheckedChange = { checked ->
                    onTaskCheckedChange(task, checked)
                }
            )
            Spacer(modifier = Modifier.height(8.dp))
        }

    }
}