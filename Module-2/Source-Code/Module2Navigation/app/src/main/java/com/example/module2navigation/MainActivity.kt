package com.example.module2navigation

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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.module2navigation.ui.theme.Module2NavigationTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            Module2NavigationTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->

                    NavigationApp(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun NavigationApp(modifier: Modifier = Modifier) {

    val navController = rememberNavController()

    var studentName by rememberSaveable {
        mutableStateOf("")
    }

    var studentId by rememberSaveable {
        mutableStateOf("")
    }

    var errorMessage by rememberSaveable {
        mutableStateOf("")
    }

    NavHost(
        navController = navController,
        startDestination = "studentForm",
        modifier = modifier
    ) {

        composable("studentForm") {

            StudentFormScreen(
                studentName = studentName,
                studentId = studentId,
                errorMessage = errorMessage,

                onNameChange = {
                    studentName = it
                },

                onIdChange = {
                    studentId = it
                },

                onContinue = {

                    if (
                        studentName.isBlank() ||
                        studentId.isBlank()
                    ) {

                        errorMessage =
                            "Please complete all fields"

                    } else {

                        errorMessage = ""

                        navController.navigate("studentDetails")
                    }
                }
            )
        }

        composable("studentDetails") {

            StudentDetailsScreen(
                studentName = studentName,
                studentId = studentId,

                onBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}

@Composable
fun StudentFormScreen(
    studentName: String,
    studentId: String,
    errorMessage: String,
    onNameChange: (String) -> Unit,
    onIdChange: (String) -> Unit,
    onContinue: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Student Information",
            fontSize = 28.sp,
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        OutlinedTextField(
            value = studentName,
            onValueChange = onNameChange,
            label = {
                Text("Student Name")
            },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        OutlinedTextField(
            value = studentId,
            onValueChange = onIdChange,
            label = {
                Text("Student ID")
            },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        if (errorMessage.isNotEmpty()) {

            Text(
                text = errorMessage,
                color = MaterialTheme.colorScheme.error
            )

            Spacer(
                modifier = Modifier.height(12.dp)
            )
        }

        Button(
            onClick = onContinue
        ) {

            Text("Continue")
        }
    }
}

@Composable
fun StudentDetailsScreen(
    studentName: String,
    studentId: String,
    onBack: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Student Details",
            fontSize = 28.sp,
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(
            modifier = Modifier.height(28.dp)
        )

        Text(
            text = "Welcome, $studentName!",
            fontSize = 22.sp
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        Text(
            text = "Student ID: $studentId",
            fontSize = 18.sp
        )

        Spacer(
            modifier = Modifier.height(32.dp)
        )

        Button(
            onClick = onBack
        ) {

            Text("Back")
        }
    }
}