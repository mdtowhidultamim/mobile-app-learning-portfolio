package com.example.module3formvalidation

import android.os.Bundle
import android.util.Patterns
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.module3formvalidation.ui.theme.Module3FormValidationTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            Module3FormValidationTheme {

                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->

                    StudentRegistrationScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun StudentRegistrationScreen(
    modifier: Modifier = Modifier
) {

    var name by rememberSaveable {
        mutableStateOf("")
    }

    var email by rememberSaveable {
        mutableStateOf("")
    }

    var studentId by rememberSaveable {
        mutableStateOf("")
    }

    var programme by rememberSaveable {
        mutableStateOf("")
    }

    var errorMessage by rememberSaveable {
        mutableStateOf("")
    }

    var successMessage by rememberSaveable {
        mutableStateOf("")
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .imePadding()
            .padding(24.dp),

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Student Registration",
            fontSize = 28.sp,
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(
            modifier = Modifier.height(28.dp)
        )

        OutlinedTextField(
            value = name,

            onValueChange = {
                name = it
            },

            label = {
                Text("Name")
            },

            singleLine = true,

            modifier = Modifier.fillMaxWidth()
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        OutlinedTextField(
            value = email,

            onValueChange = {
                email = it
            },

            label = {
                Text("Email")
            },

            singleLine = true,

            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            ),

            modifier = Modifier.fillMaxWidth()
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        OutlinedTextField(
            value = studentId,

            onValueChange = {
                studentId = it
            },

            label = {
                Text("Student ID")
            },

            singleLine = true,

            modifier = Modifier.fillMaxWidth()
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        OutlinedTextField(
            value = programme,

            onValueChange = {
                programme = it
            },

            label = {
                Text("Programme")
            },

            singleLine = true,

            modifier = Modifier.fillMaxWidth()
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        Button(
            onClick = {

                when {

                    name.isBlank() ||
                            email.isBlank() ||
                            studentId.isBlank() ||
                            programme.isBlank() -> {

                        errorMessage =
                            "Please complete all fields"

                        successMessage = ""
                    }

                    !Patterns.EMAIL_ADDRESS
                        .matcher(email)
                        .matches() -> {

                        errorMessage =
                            "Please enter a valid email"

                        successMessage = ""
                    }

                    else -> {

                        errorMessage = ""

                        successMessage =
                            "Registration successful"
                    }
                }
            }
        ) {

            Text("Register")
        }

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        if (errorMessage.isNotEmpty()) {

            Text(
                text = errorMessage,
                color = MaterialTheme.colorScheme.error,
                fontSize = 17.sp
            )
        }

        if (successMessage.isNotEmpty()) {

            Text(
                text = successMessage,
                color = MaterialTheme.colorScheme.primary,
                fontSize = 18.sp
            )

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            Text(
                text = "Name: $name"
            )

            Text(
                text = "Email: $email"
            )

            Text(
                text = "Student ID: $studentId"
            )

            Text(
                text = "Programme: $programme"
            )
        }
    }
}