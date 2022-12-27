package com.example.replyapp.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.replyapp.data.Email
import com.example.replyapp.ui.theme.ReplyAppTheme

@Composable
fun ReplyListOnlyContent(
    replyUiState: ReplyUiState,
    modifier: Modifier = Modifier
) {
    val emails = replyUiState.currentMailboxEmails

    LazyColumn(modifier = modifier.padding(horizontal = 16.dp)) {
        item { }
        items(emails, key = { email -> email.id }) { email ->
            ReplyEmailListItem(email = email)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReplyEmailListItem(email: Email, modifier: Modifier = Modifier) {
    Card(modifier = modifier.padding(vertical = 4.dp), onClick = { /*TODO*/ }) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            ReplyEmailItemHeader(email = email)
        }
    }
}

@Composable
private fun ReplyEmailItemHeader(email: Email, modifier: Modifier = Modifier) {
    Row(modifier = modifier.fillMaxWidth()) {
        ReplyProfileImage(
            drawableResource = email.sender.avatar,
            description = email.sender.fullName,
            modifier = Modifier.size(40.dp)
        )
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 12.dp, vertical = 4.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = email.sender.firstName, style = MaterialTheme.typography.labelMedium)
            Text(
                text = email.createdAt,
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.outline
            )
        }
    }
}

@Composable
fun ReplyProfileImage(
    @DrawableRes drawableResource: Int,
    description: String,
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(id = drawableResource),
        contentDescription = description,
        modifier = modifier.clip(CircleShape)
    )
}

