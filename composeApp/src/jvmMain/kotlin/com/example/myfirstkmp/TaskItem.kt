package com.example.myfirstkmp

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.* // or material.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.font.FontWeight
@Composable
fun TaskItem(task: Task, onCheckedChange: (Boolean) -> Unit) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Checkbox(
            checked = task.isCompleted,
            onCheckedChange = { onCheckedChange(it) },
        )
        Text(task.text,
            modifier = Modifier
                .padding(horizontal = 5.dp, vertical = 10.dp),
            fontWeight = FontWeight.Bold
        )
    }
}