package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ArtSpaceApp()
                }
            }
        }
    }
}


@Composable
fun ArtSpaceApp(){
    ArtSpace()
}

@Composable
fun ArtSpace(
    modifier: Modifier = Modifier
){
    Column(
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxSize()
            .padding(PaddingValues(10.dp, 10.dp))
    ) {
        Image(
            painter = painterResource(id = R.drawable.attack_on_titan),
            contentDescription = null,
            modifier = Modifier
                .wrapContentSize()
                .border(BorderStroke(5.dp, Color(105, 205, 216)))
                .padding(20.dp)
        )
        Spacer(modifier = modifier.padding(20.dp))
        ArtistAndTitle()
        ButtonPreviousAndNext()
    }
}


@Composable
fun ArtistAndTitle() {
    Column(
        modifier = Modifier
            .background(Color.White)
            .padding(20.dp)
    ) {
        Text(
            text = "Attack On Titan",
            fontSize = 30.sp,
            fontWeight = FontWeight.Light,
            textAlign = TextAlign.Left
        )
        Text(
            text = "Hajime Isayama(2009)",
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Left
        )
    }
}

@Composable
fun ButtonPreviousAndNext(){
    Row(modifier = Modifier.fi.wrapContentWidth(Al.Bottom)) {
        Button(onClick = { /*TODO*/ }) {
            Text(text = stringResource(id = R.string.previous))
        }
        Button(onClick = { /*TODO*/ }) {
            Text(text = stringResource(id = R.string.previous))
        }
    }
}

@Preview
@Composable
fun ArtSpacecPreview() {
    ArtSpaceTheme {
        ArtSpaceApp()
    }
}