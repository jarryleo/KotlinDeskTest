// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.material.MaterialTheme
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application

@Composable
@Preview
fun App() {
    var text by remember { mutableStateOf("Hello, World!") }

    MaterialTheme {
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

fun main() = application {
    val isOpen = remember { mutableStateOf(true) }
    val isAskingToClose = remember { mutableStateOf(false) }
    if (isOpen.value) {
        Window(
            onCloseRequest = { isAskingToClose.value = true },
            title = "我的第一个kotlin桌面程序",
            state = WindowState(position = WindowPosition(Alignment.Center))
        ) {
            App()
            if (isAskingToClose.value) {
                AskToCloseDialog(isOpen, isAskingToClose)
            }
        }
    }
}
