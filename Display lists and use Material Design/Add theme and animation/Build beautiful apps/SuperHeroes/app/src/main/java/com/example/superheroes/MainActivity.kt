package com.example.superheroes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superheroes.model.Hero
import com.example.superheroes.model.HeroesRepository.heroes
import com.example.superheroes.ui.theme.SuperHeroesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SuperHeroesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    SuperHeroesApp()
                }
            }
        }
    }
}

@Composable
fun SuperHeroesApp() {
    Scaffold(
        topBar = {
            SuperHeroAppBar()
        }
    ) {
        LazyColumn() {
            items(heroes) {
                SuperHeroItem(hero = it)
            }
        }
    }
}

@Composable
fun SuperHeroAppBar(modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = stringResource(id = R.string.app_name),
            style = MaterialTheme.typography.h1,
            modifier = Modifier.fillMaxWidth().size(56.dp),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun SuperHeroItem(hero: Hero, modifier: Modifier = Modifier) {
    Card(
        elevation = 2.dp,
        modifier = Modifier.padding(start = 16.dp, top = 8.dp, end = 16.dp, bottom = 8.dp)
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp)
                .sizeIn(72.dp)
        ) {
            Column(modifier = Modifier.weight(1f)) {
                SuperHeroInformation(hero.nameRes, hero.descriptionRes)
            }
            Spacer(modifier = Modifier.width(16.dp))
            SuperHeroIcon(heroAvatar = hero.imageRes)
        }
    }

}

@Composable
fun SuperHeroInformation(
    @StringRes heroName: Int,
    @StringRes heroDescription: Int,
    modifier: Modifier = Modifier
) {
    Text(
        text = stringResource(id = heroName),
        style = MaterialTheme.typography.h3
    )
    Text(
        text = stringResource(id = heroDescription),
        style = MaterialTheme.typography.body1
    )
}

@Composable
fun SuperHeroIcon(@DrawableRes heroAvatar: Int, modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .size(72.dp)
            .clip(RoundedCornerShape(8.dp))
    ) {
        Image(
            painter = painterResource(id = heroAvatar),
            contentDescription = null,
            alignment = Alignment.TopCenter,
            contentScale = ContentScale.FillWidth
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SuperHeroItemPreview() {
    SuperHeroesTheme(darkTheme = false) {
        SuperHeroItem(
            hero = Hero(
                R.string.hero1,
                R.string.description4,
                R.drawable.android_superhero1
            )
        )
    }
}

@Preview
@Composable
fun SuperHeroesAppPreview() {
    SuperHeroesTheme(darkTheme = true) {
        SuperHeroesApp()
    }
}