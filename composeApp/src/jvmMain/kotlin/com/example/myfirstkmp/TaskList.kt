package com.example.myfirstkmp

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color

@Composable
fun TaskList(tasks: List<Task>, onTaskCheckedChange: (Task, Boolean) -> Unit) {
    Box (
        modifier = Modifier
            .clip(RoundedCornerShape(14.dp))
            .fillMaxHeight(0.67f)
            .fillMaxWidth(0.35f)
            .background(Color(243,248,255)),
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            items(tasks) { task ->
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
}