package com.svape.mrolympiacompose.ui.profile

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.svape.mrolympiacompose.ui.Greeting
import com.svape.mrolympiacompose.data.api.model.ClassicPhysique
import com.svape.mrolympiacompose.ui.theme.MrOlympiaComposeTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ProfileActivity : ComponentActivity() {

    private val people: ClassicPhysique by lazy {
        intent?.getSerializableExtra(peopleID) as ClassicPhysique
    }

    companion object {
        private const val peopleID = "people_id"
        fun newIntent(context: Context, classicPhysique: ClassicPhysique) =
            Intent(context, ProfileActivity::class.java).apply {
                putExtra(peopleID, classicPhysique)
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MrOlympiaComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ProfileDetail(classicPhysique = people)
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MrOlympiaComposeTheme {
        Greeting("Wena")
    }
}