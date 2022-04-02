package com.example.pagingapplication

fun UserEntity.toUser(): User =
    User(
        this.login,
        this.id
    )