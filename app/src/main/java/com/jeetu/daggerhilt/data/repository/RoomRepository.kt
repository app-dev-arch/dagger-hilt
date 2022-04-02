package com.jeetu.daggerhilt.data.repository

import com.jeetu.daggerhilt.data.db.dao.SignUpDao
import com.jeetu.daggerhilt.data.db.model.SignUp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RoomRepository @Inject constructor(val signUpDao: SignUpDao){
    suspend fun doSignup(signUp: SignUp) = withContext(Dispatchers.IO){
        signUpDao.doSignUp(signUp)
    }
    fun getUsers() = signUpDao.getRegisterUser()
}