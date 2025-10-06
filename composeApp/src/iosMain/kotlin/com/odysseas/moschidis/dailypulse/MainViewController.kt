package com.odysseas.moschidis.dailypulse

import androidx.compose.ui.window.ComposeUIViewController

fun MainViewController() = ComposeUIViewController {
    val platform = Platform()
    platform.logSystemInfo()

    App()
}