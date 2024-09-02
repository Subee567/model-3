package com.example.model3.pages

import AuthViewModel
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun MenteeHomePage(navController: NavHostController,authViewModel: AuthViewModel) {
    Surface(modifier = Modifier.fillMaxSize(),color = Color.Cyan)
    {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Welcome to Mentee Home Page", fontSize = 24.sp)
        // Add additional UI components for mentees here

        TextButton(modifier = Modifier.height(30.dp).width(100.dp),
            onClick = {
                authViewModel.signOut()
            }) {
            Text(text = "Sign Out")

        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Procces on Going I just Doing The backend Outline Phase", fontSize = 24.sp)
    }
    }

}
