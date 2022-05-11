package com.prography.composeapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.prography.composeapplication.ui.theme.ComposeApplicationTheme

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<GithubViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting(viewModel = viewModel)
                }
            }
        }
    }
}

@Composable
fun Greeting(viewModel: GithubViewModel) {

    val userData by viewModel.userData.collectAsState()

    val userData2 = viewModel.userData.collectAsState()
//
//    Column {
//        Row {
//            Text(text = "Hello $name!", style = MaterialTheme.typography.body2)
//            Spacer(modifier = Modifier.width(Dp(8f)))
//            Text(text = "Temp", style = MaterialTheme.typography.body2)
//        }
//    }

    LazyColumn() {
        item {
            Text("Header")
        }

        items(userData) { item ->
            Text(item.login)
        }

        item {
            Text("Footer")
        }
    }


}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeApplicationTheme {
        Greeting(viewModel = GithubViewModel())
    }
}