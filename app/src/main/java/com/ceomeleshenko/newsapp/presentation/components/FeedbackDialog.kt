package com.ceomeleshenko.newsapp.presentation.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun FeedbackDialog(
    onDismiss: () -> Unit,
    onRate: (Int) -> Unit
) {
    var rating by remember { mutableIntStateOf(0) }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Оцените наше приложение") },
        text = {
            RatingBar(rating = rating) {
                rating = it
            }
        },
        confirmButton = {
            Button(onClick = {
                onRate(rating)
                onDismiss()
            }) {
                Text("Оценить")
            }
        },
        dismissButton = {
            Button(onClick = onDismiss) {
                Text("Отмена")
            }
        }
    )
}