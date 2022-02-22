package ui

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import theme.AppTheme

@Composable
@Preview
fun App() {
    var text by remember { mutableStateOf("Hello, World!") }

    AppTheme {
        Box(modifier = Modifier.fillMaxSize()) {
            Button(
                modifier = Modifier.align(Alignment.Center),
                onClick = {
                    text = "Hello, Desktop!"
                }) {
                Text(text)
            }
        }
    }
}