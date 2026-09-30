package com.example.module1uieventhandling

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.module1uieventhandling.ui.theme.Module1UiEventHandlingTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            Module1UiEventHandlingTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    StudentInteractionScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun StudentInteractionScreen(modifier: Modifier = Modifier) {

    var name by rememberSaveable {
        mutableStateOf("")
    }

    var message by rememberSaveable {
        mutableStateOf("Welcome!")
    }

    var count by rememberSaveable {
        mutableIntStateOf(0)
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Student Interaction App",
            fontSize = 26.sp,
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(24.dp))

        OutlinedTextField(
            value = name,
            onValueChange = {
                name = it
            },
            label = {
                Text("Enter your name")
            },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                message =
                    if (name.isBlank()) {
                        "Please enter your name"
                    } else {
                        "Hello, $name!"
                    }
            }
        ) {
            Text("Submit")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = message,
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Button clicked: $count times"
        )

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = {
                count++
            }
        ) {
            Text("Increase Counter")
        }
    }
}