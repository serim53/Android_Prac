package com.example.myapplication

import com.example.myapplication.data.entity.UserDto
import com.example.myapplication.domain.model.User

fun UserDto.toUser(): User =
    User(login, id)