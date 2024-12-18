package me.auth_sample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import me.auth_kit_aos.auth_kit_ui.AuthView
import me.auth_sample.ui.theme.Auth_sampleTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val user = Firebase.auth.currentUser
            Auth_sampleTheme {
                Scaffold() { innerPadding ->
                    Box(
                        Modifier.fillMaxSize().padding(innerPadding),
                        contentAlignment = Alignment.Center,
                    ) {
                        if (user != null) {
                            Column {
                                Text("Hello " + user.uid)
                                Button(
                                    onClick = {
                                        CoroutineScope(Dispatchers.Main).launch {
                                            Firebase.auth.signOut()
                                        }
                                    }
                                ) {
                                    Text("Sign out")
                                }
                            }
                        } else {
                            AuthView()
                        }
                    }
                }
            }
        }
    }
}
