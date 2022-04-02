package com.jeetu.apparchitectwithdaggerhilt.ui.sign_up

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jeetu.apparchitectwithdaggerhilt.R
import com.jeetu.apparchitectwithdaggerhilt.data.db.model.SignUp
import com.jeetu.apparchitectwithdaggerhilt.data.repository.RoomRepository
import com.jeetu.apparchitectwithdaggerhilt.databinding.ActivitySignupBinding
import com.jeetu.apparchitectwithdaggerhilt.utils.showSmallToast
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(val roomRepository: RoomRepository): ViewModel() {
    fun getUsers() = roomRepository.getUsers()
    fun doSignUp(signUp: SignUp,@ApplicationContext context : Context) = viewModelScope.launch {
        roomRepository.doSignup(signUp)
    }
    fun doValidateLogin(binding: ActivitySignupBinding) : Boolean{
        var isValid = false
        if (binding.emailEdtTxt.text.isEmpty()){
            //binding.emailEdtTxt.setError(binding.root.context.getString(R.string.please_enter_email))
            binding.root.context.showSmallToast(binding.root.context.getString(R.string.please_enter_email))
        }else if (binding.passEdtTxt.text.isEmpty()){
            //binding.passText.setError(binding.root.context.getString(R.string.please_enter_pass))
            binding.root.context.showSmallToast(binding.root.context.getString(R.string.please_enter_pass))
        } else {
            isValid = true
        }
        return isValid
    }
    fun resetSignUpData(binding: ActivitySignupBinding){
        binding.emailEdtTxt.text.clear()
        binding.passEdtTxt.text.clear()
    }
}