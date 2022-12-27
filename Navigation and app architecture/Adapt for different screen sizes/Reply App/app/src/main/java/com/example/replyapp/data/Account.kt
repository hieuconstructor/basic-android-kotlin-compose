package com.example.replyapp.data

import androidx.annotation.DrawableRes

data class Account(
    /** Unique ID of a user **/
    val id: Int,
    /** User's first name **/
    val firstName: String,
    /** User's last name **/
    val lastName: String,
    /** User's email address **/
    val email: String,
    /** User's avatar image resource id **/
    @DrawableRes val avatar: Int
) {
    /** User's full name **/
    val fullName: String = "$firstName $lastName"
}
