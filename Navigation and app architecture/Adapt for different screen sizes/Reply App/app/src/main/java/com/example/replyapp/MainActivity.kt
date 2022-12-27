package com.example.replyapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.replyapp.ui.ReplyApp
import com.example.replyapp.ui.theme.ReplyAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ReplyAppTheme {
                ReplyApp()
            }
        }
    }
}

@Preview
@Composable
fun ReplyAppPreview() {
    ReplyAppTheme {
        ReplyApp()
    }
}

