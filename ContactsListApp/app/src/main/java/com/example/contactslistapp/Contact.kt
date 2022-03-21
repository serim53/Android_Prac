package com.example.contactslistapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contact")
data class Contact(
    // autoGenerate -> id가 null일 경우 자동으로 id 생성
    @PrimaryKey(autoGenerate = true) var id: Long?,
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "number") var number: String,
    @ColumnInfo(name = "initial") var initial: Char
)