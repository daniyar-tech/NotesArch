package com.example.notesarch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.notesarch.presentation.auth.AuthScreen
import com.example.notesarch.presentation.notes.NotesScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface {
                    val navController = rememberNavController()
                    NavHost(navController, startDestination = "auth") {
                        composable("auth") {
                            AuthScreen(onLoginSuccess = {
                                navController.navigate("notes") {
                                    popUpTo("auth") { inclusive = true }
                                }
                            })
                        }
                        composable("notes") {
                            NotesScreen(onLogout = {
                                navController.navigate("auth") {
                                    popUpTo("notes") { inclusive = true }
                                }
                            })
                        }
                    }
                }
            }
        }
    }
}