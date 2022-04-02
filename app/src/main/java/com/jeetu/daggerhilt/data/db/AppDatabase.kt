package com.jeetu.daggerhilt.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jeetu.daggerhilt.data.db.dao.SignUpDao
import com.jeetu.daggerhilt.data.db.model.SignUp
import com.jeetu.daggerhilt.utils.DataBaseConstant

@Database(entities = [SignUp::class], version = DataBaseConstant.DATABASE_VERSION, exportSchema = false)
abstract class AppDatabase : RoomDatabase(){
    abstract fun getSignUpDao() : SignUpDao
}