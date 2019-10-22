package com.example.mvp.model

class UserModel(private val userName: String, private val passWd: String) : IUser.Model {

    override fun getName(): String {
        return userName
    }

    override fun getPassWord(): String {
        return passWd
    }

    override fun checkUserValidity(name: String, pw: String): Int {
        return if (name != getName() || pw != getPassWord()) {
            -1
        } else 0
    }
}