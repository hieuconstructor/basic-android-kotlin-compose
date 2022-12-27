package com.example.replyapp.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.NavigationRailItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Drafts
import androidx.compose.material.icons.filled.Inbox
import androidx.compose.material.icons.filled.Report
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.*
import androidx.compose.material3.NavigationRailItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import com.example.replyapp.R
import com.example.replyapp.data.MailboxType

@Composable
fun ReplyHomeScreen(
    replyUiState: ReplyUiState,
    onTabPressed: (MailboxType) -> Unit,
    modifier: Modifier = Modifier
) {
    val navigationItemContentList = listOf(
        NavigationItemContent(
            mailboxType = MailboxType.Inbox,
            icon = Icons.Default.Inbox,
            text = stringResource(id = R.string.tab_inbox)
        ),
        NavigationItemContent(
            mailboxType = MailboxType.Sent,
            icon = Icons.Default.Send,
            text = stringResource(id = R.string.tab_sent)
        ),
        NavigationItemContent(
            mailboxType = MailboxType.Drafts,
            icon = Icons.Default.Drafts,
            text = stringResource(id = R.string.tab_drafts)
        ),
        NavigationItemContent(
            mailboxType = MailboxType.Spam,
            icon = Icons.Default.Report,
            text = stringResource(id = R.string.tab_spam)
        )
    )
    ReplyAppContent(replyUiState = replyUiState , onTabPressed = onTabPressed, navigationItemContentList =  navigationItemContentList)
}

@Composable
private fun ReplyAppContent(
    replyUiState: ReplyUiState,
    onTabPressed: ((MailboxType) -> Unit),
    navigationItemContentList: List<NavigationItemContent>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.inverseOnSurface)
    ) {
        ReplyListOnlyContent(
            replyUiState = replyUiState,
            modifier = Modifier.weight(1f)
        )
        ReplyBottomNavigationBar(
            currentTab = replyUiState.currentMailbox,
            onTabPressed = onTabPressed,
            navigationItemContentList = navigationItemContentList
        )
    }
}


/**
 * Component that displays Navigation Rail
 */
@Composable
private fun ReplyNavigationRail(
    currentTab: MailboxType,
    onTabPressed: ((MailboxType) -> Unit) = {},
    navigationItemContentList: List<NavigationItemContent>,
    modifier: Modifier = Modifier
) {
    NavigationRail(modifier = modifier.fillMaxHeight()) {
        for (navItem in navigationItemContentList) {
            NavigationRailItem(
                selected = currentTab == navItem.mailboxType,
                onClick = { onTabPressed(navItem.mailboxType) },
                icon = {
                    Icon(
                        imageVector = navItem.icon,
                        contentDescription = navItem.text
                    )
                }
            )
        }
    }
}


@Composable
private fun ReplyBottomNavigationBar(
    currentTab: MailboxType,
    onTabPressed: ((MailboxType) -> Unit) = {},
    navigationItemContentList: List<NavigationItemContent>,
    modifier: Modifier = Modifier
) {
    NavigationBar(modifier = modifier.fillMaxHeight()) {
        for (navItem in navigationItemContentList) {
            NavigationBarItem(
                selected = currentTab == navItem.mailboxType,
                onClick = { onTabPressed(navItem.mailboxType) },
                icon = {
                    Icon(
                        imageVector = navItem.icon,
                        contentDescription = navItem.text
                    )
                }
            )
        }
    }
}

private data class NavigationItemContent(
    val mailboxType: MailboxType,
    val icon: ImageVector,
    val text: String
)