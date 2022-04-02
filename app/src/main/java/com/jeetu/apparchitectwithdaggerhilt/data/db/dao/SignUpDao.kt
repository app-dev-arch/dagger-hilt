package com.jeetu.apparchitectwithdaggerhilt.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.jeetu.apparchitectwithdaggerhilt.data.db.model.SignUp
import com.jeetu.apparchitectwithdaggerhilt.utils.DataBaseConstant

@Dao
interface SignUpDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun doSignUp(signUp: SignUp)

    @Update
    suspend fun doUpdate(signUp: SignUp)

    @Delete
    suspend fun doDelete(signUp: SignUp)

    @Query("select * from ${DataBaseConstant.TABLE_SIGNUP}")
    fun getRegisterUser() : LiveData<List<SignUp>>
}