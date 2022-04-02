package com.jeetu.daggerhilt.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.jeetu.daggerhilt.data.db.model.SignUp
import com.jeetu.daggerhilt.utils.DataBaseConstant.TABLE_SIGNUP

@Dao
interface SignUpDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun doSignUp(signUp: SignUp)

    @Update
    suspend fun doUpdate(signUp: SignUp)

    @Delete
    suspend fun doDelete(signUp: SignUp)

    @Query("select * from ${TABLE_SIGNUP}")
    fun getRegisterUser() : LiveData<List<SignUp>>
}