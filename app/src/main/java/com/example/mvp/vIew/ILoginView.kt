package com.example.mvp.vIew

interface ILoginView {
    fun onClearText()
    fun onLoginResult(result: Boolean, code: Int)
    fun onSetProgressBarVisibility(visibility: Int)
}