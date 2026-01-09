package com.example.myfirstkmp

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.* // or material.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun TaskItem(task: Task, onCheckedChange: (Boolean) -> Unit) {
    Row (
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Checkbox(
            modifier = Modifier
                .background(Color.LightGray),
            checked = task.isCompleted,
            onCheckedChange = { onCheckedChange(it) },
        )
        Text(task.text,
            color = Color.White,
            modifier = Modifier
                .padding(8.dp)
        )
    }
}