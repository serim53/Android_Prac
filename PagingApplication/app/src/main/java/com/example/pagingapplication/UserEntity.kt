package com.example.pagingapplication

import com.google.gson.annotations.SerializedName


// entity => 데이터 통신에 사용

data class UserEntity (
    @SerializedName("login")
    val login: String,
    @SerializedName("id")
    val id: Int

)