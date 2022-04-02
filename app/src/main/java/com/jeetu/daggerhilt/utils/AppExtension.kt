package com.jeetu.daggerhilt.utils

import android.content.Context
import android.net.ConnectivityManager
import android.widget.Toast

fun Context.showLongToast(msg : String){
    Toast.makeText(this,msg,Toast.LENGTH_LONG).show()
}
fun Context.showSmallToast(msg : String){
    Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
}
fun Context.isNetworkAvailable(): Boolean {
    val connectivityManager =
        getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetwork = connectivityManager.activeNetworkInfo
    return (activeNetwork != null && activeNetwork.isConnected)
}