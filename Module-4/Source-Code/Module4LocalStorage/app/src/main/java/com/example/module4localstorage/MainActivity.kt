package com.example.module4localstorage

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.module4localstorage.ui.theme.Module4LocalStorageTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            Module4LocalStorageTheme {

                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->

                    NotesScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun NotesScreen(
    modifier: Modifier = Modifier
) {

    val context = LocalContext.current

    val sharedPreferences = remember {
        context.getSharedPreferences(
            "student_notes",
            Context.MODE_PRIVATE
        )
    }

    val savedNotes = remember {
        sharedPreferences
            .getStringSet("notes", emptySet())
            ?.toList()
            ?: emptyList()
    }

    val notes = remember {
        mutableStateListOf<String>().apply {
            addAll(savedNotes)
        }
    }

    var noteText by rememberSaveable {
        mutableStateOf("")
    }

    var message by rememberSaveable {
        mutableStateOf("")
    }

    fun saveNotes() {

        sharedPreferences
            .edit()
            .putStringSet(
                "notes",
                notes.toSet()
            )
            .apply()
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),

        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        Text(
            text = "Student Notes",
            fontSize = 28.sp,
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        OutlinedTextField(
            value = noteText,

            onValueChange = {
                noteText = it
            },

            label = {
                Text("Enter a note")
            },

            modifier = Modifier.fillMaxWidth()
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        Button(
            onClick = {

                if (noteText.isBlank()) {

                    message = "Please enter a note"

                } else {

                    notes.add(noteText.trim())

                    saveNotes()

                    noteText = ""

                    message = "Note saved successfully"
                }
            }
        ) {

            Text("Save Note")
        }

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        if (message.isNotEmpty()) {

            Text(
                text = message,
                color = if (
                    message == "Please enter a note"
                ) {
                    MaterialTheme.colorScheme.error
                } else {
                    MaterialTheme.colorScheme.primary
                }
            )
        }

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        Text(
            text = "Saved Notes",
            fontSize = 22.sp
        )

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        if (notes.isEmpty()) {

            Text("No notes saved")

        } else {

            LazyColumn(
                modifier = Modifier.fillMaxWidth()
            ) {

                items(
                    items = notes.toList()
                ) { note ->

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 6.dp)
                    ) {

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),

                            horizontalArrangement =
                                Arrangement.SpaceBetween,

                            verticalAlignment =
                                Alignment.CenterVertically
                        ) {

                            Text(
                                text = note,
                                modifier = Modifier.weight(1f)
                            )

                            Button(
                                onClick = {

                                    notes.remove(note)

                                    saveNotes()

                                    message =
                                        "Note deleted"
                                }
                            ) {

                                Text("Delete")
                            }
                        }
                    }
                }
            }
        }
    }
}