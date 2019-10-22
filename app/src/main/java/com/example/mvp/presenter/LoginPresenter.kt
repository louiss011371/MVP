package com.example.mvp.presenter

import com.example.mvp.MainActivity
import com.example.mvp.model.IUser
import com.example.mvp.model.UserModel


class LoginPresenter(private val iLoginView: MainActivity) : IUser.Presenter {

    private var user: IUser.Model? = null

    init {
        initUser()
    }

    override fun clear() {
        iLoginView.onClearText()
    }

    override fun doLogin(name: String, pw: String) {
        val isSuccessful = true
        val code: Int? = user?.checkUserValidity(name, pw)
        if (code == 0) {
            code.let { iLoginView.onLoginResult(isSuccessful, it) }
        }
    }

    override fun setProgressBarVisibility(visibility: Int) {
        iLoginView.onSetProgressBarVisibility(visibility)
    }

    private fun initUser() {
        user = UserModel("mvp", "mvp")
    }
}