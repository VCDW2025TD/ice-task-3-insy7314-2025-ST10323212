package com.example.memestream.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.memestream.data.model.UserMeme

@Database(entities = [UserMeme::class], version = 1)
abstract class UserMemeDatabase : RoomDatabase() {
    abstract fun userMemeDao(): UserMemeDao

    companion object {
        @Volatile
        private var INSTANCE: UserMemeDatabase? = null

        fun getInstance(context: Context): UserMemeDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UserMemeDatabase::class.java,
                    "memestream.db"
                ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                instance
            }
        }
    }
}
