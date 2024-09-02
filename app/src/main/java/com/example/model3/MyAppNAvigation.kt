package com.example.model3

import AuthViewModel
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.model3.Pages.HomePage
import com.example.model3.Pages.HomePage
import com.example.model3.Pages.LoginPage
import com.example.model3.Pages.SignupPage


@Composable
fun MyAppNavigation (modifier: Modifier = Modifier,authViewModel: AuthViewModel){
    val navController = rememberNavController()
    
    NavHost(navController = navController, startDestination = "login", builder = {
        composable("login"){
            LoginPage(modifier,navController,authViewModel)
        }
        composable("home"){
            HomePage(modifier,navController,authViewModel)
        }
        composable("signup"){
            SignupPage(modifier,navController,authViewModel)
        }
    })
}