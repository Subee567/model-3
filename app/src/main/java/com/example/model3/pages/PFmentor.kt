package com.example.model3

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun PFmentor(navController: NavController, mentorViewModel: MentorViewModel) {
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var career by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Edit Mentor Profile", fontSize = 24.sp)

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = firstName,
            onValueChange = { firstName = it },
            label = { Text("First Name") }
        )
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = lastName,
            onValueChange = { lastName = it },
            label = { Text("Last Name") }
        )
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") }
        )
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = career,
            onValueChange = { career = it },
            label = { Text("Career") }
        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            val mentorDetails = MentorDetails(
                firstName = firstName,
                lastName = lastName,
                email = email,
                career = career
            )
            mentorViewModel.updateMentorDetails(mentorDetails)
            navController.navigate("mentor_home") // Navigate back to MentorPage
        }) {
            Text(text = "Save Profile")
        }
    }
}
