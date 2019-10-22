package com.example.mvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.view.View
import android.widget.Toast
import com.example.mvp.model.IUser
import com.example.mvp.presenter.LoginPresenter

class MainActivity : AppCompatActivity(), IUser.LoginView {

    var loginPresenter: IUser.Presenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loginPresenter = LoginPresenter(this)
        loginPresenter?.setProgressBarVisibility(View.INVISIBLE)

        btn_login_clear.setOnClickListener {
            loginPresenter?.clear()
        }

        btn_login_login.setOnClickListener {
            loginPresenter?.setProgressBarVisibility(View.VISIBLE)
            btn_login_login.isEnabled = false
            btn_login_clear.isEnabled = false
            loginPresenter?.doLogin(et_login_username.text.toString(), et_login_password.text.toString())
        }
    }

    override fun onClearText() {
        et_login_username.setText("")
        et_login_password.setText("")
    }

    override fun onLoginResult(result: Boolean, code: Int) {
        loginPresenter?.setProgressBarVisibility(View.INVISIBLE)
        btn_login_login.isEnabled = true
        btn_login_clear.isEnabled = true
        if (result) {
            Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show()
        } else
            Toast.makeText(this, "Login Fail, code = $code", Toast.LENGTH_SHORT).show()
    }

    override fun onSetProgressBarVisibility(visibility: Int) {
        progress_login.visibility = visibility
    }
}
