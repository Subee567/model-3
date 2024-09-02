package com.example.model3

import AuthViewModel
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.model3.ui.theme.Model3Theme

class MainActivity : ComponentActivity() {
    private val authViewModel: AuthViewModel by viewModels()
    private val mentorViewModel: MentorViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Model3Theme {

                val startDestination = if (SharedPrefsHelper.getSignupStatus(this)) {
                    SharedPrefsHelper.getUserChoice(this)?.let {
                        if (it == "mentor") "mentor_home" else "mentee_home"
                    } ?: "choicePF"
                } else {
                    "signup"
                }

                Log.d("com.example.model3.MainActivity", "Current startDestination: $startDestination")

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyAppNavigation(
                        modifier = Modifier.padding(innerPadding),
                        authViewModel = authViewModel,
                        mentorViewModel = mentorViewModel,
                        startDestination = startDestination
                    )
                }
            }
        }
    }
}
