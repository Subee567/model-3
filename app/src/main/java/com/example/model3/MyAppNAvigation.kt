package com.example.model3

import AuthViewModel
import MentorPage
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.model3.pages.ChoicePF
import com.example.model3.pages.HomePage
import com.example.model3.pages.LoginPage
import com.example.model3.pages.SignupPage


@Composable
fun MyAppNavigation(
    modifier: Modifier = Modifier,
    authViewModel: AuthViewModel,
    mentorViewModel: MentorViewModel,
    startDestination: String,
) { val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable("login") {
            LoginPage(modifier, navController, authViewModel)
        }
        composable("home") {
            HomePage(modifier, authViewModel)  // Use the passed instance of AuthViewModel
        }
        composable("signup") {
            SignupPage(modifier, navController, authViewModel)
        }
        composable("choosing") {
            ChoicePF(navController)
        }
        composable("PFmentor") {
            PFmentor(navController, mentorViewModel)
        }
        composable("mentor_home") {
            MentorPage(navController, mentorDetails = MentorDetails())
        }
    }
}
