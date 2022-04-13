package ui// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import AskToCloseDialog
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application

fun main() = application {
    val isOpen = remember { mutableStateOf(true) }
    val isAskingToClose = remember { mutableStateOf(false) }
    if (isOpen.value) {
        Window(
            onCloseRequest = { isAskingToClose.value = true },
            title = "我的第一个kotlin桌面程序",
            icon = painterResource("ic_launcher.png"),
            state = WindowState(position = WindowPosition(Alignment.Center))
        ) {
            App()
            if (isAskingToClose.value) {
                AskToCloseDialog(isOpen, isAskingToClose)
            }
        }
    }
}
