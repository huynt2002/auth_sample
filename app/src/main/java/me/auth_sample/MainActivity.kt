package me.auth_sample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import dagger.hilt.android.AndroidEntryPoint
import me.auth_kit_aos.auth_kit_ui.AuthView
import me.auth_sample.ui.theme.Auth_sampleTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Auth_sampleTheme {
                Scaffold() { innerPadding ->
                    Box(Modifier.fillMaxSize().padding(innerPadding)) { AuthView() }
                }
            }
        }
    }
}
