package com.jeetu.apparchitectwithdaggerhilt.di

import android.content.Context
import androidx.room.Room
import com.jeetu.apparchitectwithdaggerhilt.data.db.AppDatabase
import com.jeetu.apparchitectwithdaggerhilt.data.db.dao.SignUpDao
import com.jeetu.apparchitectwithdaggerhilt.utils.DataBaseConstant.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    @Singleton
    @Provides
    @Named("db_name")
    fun getDataBaseName() : String = DATABASE_NAME

    @Singleton
    @Provides
    fun getDataBase(@ApplicationContext context: Context,@Named("db_name") dbName : String) : AppDatabase = Room.databaseBuilder(context,AppDatabase::class.java,dbName).build()

    @Singleton
    @Provides
    fun getSignUpDao(appDatabase: AppDatabase) : SignUpDao = appDatabase.getSignUpDao()
}