package com.example.mvp.model

interface IUser {

    fun getName() : String

    fun getPassWord() : String

    fun checkUserValidity(name: String, passWord: String) : Int

//    interface Presenter {
//        fun clear()
//        fun doLogin(name: String, passwd: String)
//        fun setProgressBarVisiblity(visiblity: Int)
//    }


}