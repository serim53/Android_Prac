package com.example.myapplication.data.entity

import com.google.gson.annotations.SerializedName

// 데이터 레이어, 데이터 교환 직접적으로 통신
// data transfer object
data class UserDto(
    @SerializedName("login")
    val login: String,
    @SerializedName("id")
    val id: String,
)
