package com.example.mvp.presenter

import com.example.mvp.model.IUser
import com.example.mvp.vIew.ILoginView
import java.util.logging.Handler
import com.example.mvp.model.UserModel






class LoginPresenterCompl constructor(val iLoginView: ILoginView) : ILoginPresenter{

    var user: IUser ?=null
    lateinit var handler: Handler


    override fun clear() {
        iLoginView.onClearText()

    }
    init {
        initUser()
    }

    override fun doLogin(name: String, passwd: String) {
        val isSuccessful = true
        val code: Int? = user?.checkUserValidity(name, passwd)
        if (code == 0) {
            code?.let { iLoginView.onLoginResult(isSuccessful, it) }

        }

    }

    override fun setProgressBarVisiblity(visiblity: Int) {
        iLoginView.onSetProgressBarVisibility(visiblity)
    }

    private fun initUser() {
        user = UserModel("mvp","mvp")
    }

}