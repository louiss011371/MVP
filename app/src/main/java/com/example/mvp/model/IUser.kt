package com.example.mvp.model

interface IUser {

    interface Model {
        fun getName(): String
        fun getPassWord(): String
        fun checkUserValidity(name: String, pw: String): Int
    }

    interface Presenter {
        fun clear()
        fun doLogin(name: String, pw: String)
        fun setProgressBarVisibility(visibility: Int)
    }

    interface LoginView {
        fun onClearText()
        fun onLoginResult(result: Boolean, code: Int)
        fun onSetProgressBarVisibility(visibility: Int)
    }


}