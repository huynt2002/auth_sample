package me.auth_sample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import me.auth_kit_aos.auth_kit_ui.AuthView
import me.auth_kit_aos.auth_kit_ui.components.MarkDownTest
import me.auth_sample.ui.theme.Auth_sampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Auth_sampleTheme {
                AuthView()
            }
        }
    }
}