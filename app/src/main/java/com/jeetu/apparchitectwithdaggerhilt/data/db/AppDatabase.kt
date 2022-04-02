package com.jeetu.apparchitectwithdaggerhilt.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jeetu.apparchitectwithdaggerhilt.data.db.dao.SignUpDao
import com.jeetu.apparchitectwithdaggerhilt.data.db.model.SignUp
import com.jeetu.apparchitectwithdaggerhilt.utils.DataBaseConstant

@Database(entities = [SignUp::class], version = DataBaseConstant.DATABASE_VERSION, exportSchema = false)
abstract class AppDatabase : RoomDatabase(){
    abstract fun getSignUpDao() : SignUpDao
}