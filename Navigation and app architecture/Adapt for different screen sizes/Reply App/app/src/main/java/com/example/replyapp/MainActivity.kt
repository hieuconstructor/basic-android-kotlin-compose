package com.example.replyapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.replyapp.ui.ReplyApp
import com.example.replyapp.ui.theme.ReplyAppTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ReplyAppTheme {
                val windowSize = calculateWindowSizeClass(activity = this)
                ReplyApp(
                    windowSize = windowSize.widthSizeClass
                )
            }
        }
    }
}

@Preview
@Composable
fun ReplyAppPreview() {
    ReplyAppTheme {
        ReplyApp(
            windowSize = WindowWidthSizeClass.Compact
        )
    }
}

@Preview(showBackground = true, widthDp = 1000)
@Composable
fun ReplyAppExpandedPreview() {
    ReplyAppTheme {
        ReplyApp(windowSize = WindowWidthSizeClass.Expanded)
    }
}

@Preview(showBackground = true, widthDp = 700)
@Composable
fun ReplyAppMediumPreview() {
    ReplyAppTheme {
        ReplyApp(windowSize = WindowWidthSizeClass.Medium)
    }
}