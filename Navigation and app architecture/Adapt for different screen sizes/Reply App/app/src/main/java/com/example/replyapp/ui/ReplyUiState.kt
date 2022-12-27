package com.example.replyapp.ui

import com.example.replyapp.data.local.LocalEmailsDataProvider
import com.example.replyapp.data.Email
import com.example.replyapp.data.MailboxType

data class ReplyUiState(
    /** Emails map for all type of [MailboxType] **/
    val mailboxes: Map<MailboxType, List<Email>> = emptyMap(),
    /** Current mailbox being displayed **/
    val currentMailbox: MailboxType = MailboxType.Inbox,
    /** Current selected email for the mailbox being displayed **/
    val currentSelectedEmail: Email = LocalEmailsDataProvider.defaultEmail,
    /** Whether currently displaying homepage **/
    val isShowingHomepage: Boolean = true
) {
    /** Current list of emails for the mailbox being displayed **/
    val currentMailboxEmails: List<Email> by lazy { mailboxes[currentMailbox]!! }
}