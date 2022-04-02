package com.jeetu.daggerhilt.ui.sign_up
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.viewbinding.ViewBinding
import com.jeetu.daggerhilt.data.db.model.SignUp
import com.jeetu.daggerhilt.databinding.ActivitySignupBinding
import com.jeetu.daggerhilt.ui.base.BaseActivity
import com.jeetu.daggerhilt.ui.post.PostActivity
import dagger.hilt.android.AndroidEntryPoint
@AndroidEntryPoint
class SignUpActivity : BaseActivity<ActivitySignupBinding>() {
    private lateinit var mBinding: ActivitySignupBinding
    private val signUpViewModel : SignUpViewModel by viewModels()
    override fun getViewBinding() = ActivitySignupBinding.inflate(layoutInflater)
    override fun onActivityReady(savedInstanceState: Bundle?, binding: ViewBinding) {
        mBinding = binding as ActivitySignupBinding
        signUpViewModel.getUsers().observe(this, Observer { signUpUserList ->
            //get signup users
            signUpUserList?.let {
              if (it.size>0 && it.get(it.size-1).email.equals(mBinding.emailEdtTxt.text.toString()))  {
                  startActivity(Intent(this, PostActivity::class.java))
                  signUpViewModel.resetSignUpData(binding)
              }
            }
        })
        mBinding.signUpBtn.setOnClickListener {
            if (signUpViewModel.doValidateLogin(mBinding)){
                signUpViewModel.doSignUp(SignUp("${mBinding.emailEdtTxt.text}","${mBinding.passEdtTxt.text}"),this)
            }
        }
    }
}