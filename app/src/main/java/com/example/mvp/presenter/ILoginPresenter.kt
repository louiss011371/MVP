package com.example.mvp.presenter

interface ILoginPresenter {
    fun clear()
    fun doLogin(name: String, passwd: String)
    fun setProgressBarVisiblity(visiblity: Int)
}