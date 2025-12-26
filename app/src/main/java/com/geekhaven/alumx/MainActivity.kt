package com.geekhaven.alumx

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.geekhaven.alumx.ui.theme.AlumXTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AlumXTheme {
                AlumXApp()
            }
        }
    }
}

enum class AlumXScreen() {
    OnBoarding
}


@Composable
fun AlumXApp(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    Scaffold(contentWindowInsets = WindowInsets(0)) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = AlumXScreen.OnBoarding.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = AlumXScreen.OnBoarding.name) {
                OnBoarding(modifier = Modifier.fillMaxSize())
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun AlumXAppPreview() {
    AlumXTheme {
        AlumXApp()
    }
}