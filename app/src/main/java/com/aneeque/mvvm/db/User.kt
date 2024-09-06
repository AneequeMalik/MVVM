package com.aneeque.mvvm.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "email") val email: String?,
    @ColumnInfo(name = "username") val username: String?,
    @ColumnInfo(name = "password") val password: String?
)
