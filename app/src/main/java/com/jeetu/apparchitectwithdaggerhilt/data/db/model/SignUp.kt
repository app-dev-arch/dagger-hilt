package com.jeetu.apparchitectwithdaggerhilt.data.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SignUp(
    @PrimaryKey
    var email : String,
    var pass : String
)