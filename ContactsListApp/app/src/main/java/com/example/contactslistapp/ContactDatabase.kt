package com.example.contactslistapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Contact::class], version = 1)
abstract class ContactDatabase : RoomDatabase(){

    abstract fun contactDao(): ContactDao

    companion object {
        private var instance: ContactDatabase? = null

        // synchronized ->여러 스레드가 동시 접근 X
        @Synchronized
        fun getInstance(context: Context): ContactDatabase? {
            if (instance == null) {
                synchronized(ContactDatabase::class) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ContactDatabase::class.java,
                        "contact-database")
                            // 데이터베이스가 갱신될 때 기존 테이블 버리고 새로 사용하도록 설정
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return instance
        }
    }
}