package com.example.model3.pages

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import AuthViewModel
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun HomePage(modifier : Modifier, authViewModel :AuthViewModel){

    Surface(modifier = modifier.fillMaxSize(), color = Color.Cyan)
    {

        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(text = "HIII")

            TextButton(onClick = {
                authViewModel.signOut()
            }) {
                Text(text = "Sign Out")

            }
        }
    }
}

@Preview
@Composable
fun HomePagePreview() {
    HomePage( modifier = Modifier,AuthViewModel())
}
