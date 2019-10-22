package com.example.mvp.model

class UserModel(val userName : String, val passWd : String) : IUser {

//    val userName : String
//    val passWd : String
//
//    init {
//        userName = ""
//        passWd = ""
//    }


    override fun getName(): String {
        return userName
    }

    override fun getPassWord(): String {
        return passWd
    }

    override fun checkUserValidity(name: String, passwd: String): Int {
        return if (name != getName() || passwd != getPassWord()) {
            -1
        } else 0
    }

}