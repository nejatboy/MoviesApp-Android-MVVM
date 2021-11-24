package com.newgamesoftware.moviesdemo_android_mvvm.base

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity: AppCompatActivity() {

    abstract fun showProgress()

    abstract fun hideProgress()


    fun showMessage(message: String) {
        hideProgress()
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}