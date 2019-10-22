package com.example.mvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import com.example.mvp.vIew.ILoginView
import kotlinx.android.synthetic.main.activity_main.*
import com.example.mvp.presenter.ILoginPresenter
import android.view.View
import android.widget.Toast
import com.example.mvp.presenter.LoginPresenterCompl






class MainActivity : AppCompatActivity(), ILoginView {

    var loginPresenter: ILoginPresenter? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val editUser = findViewById<EditText>(R.id.et_login_username)
        val editPass = findViewById<EditText>(R.id.et_login_password)
        val btnLogin = findViewById<Button>(R.id.btn_login_login)
        val btnClear = findViewById<Button>(R.id.btn_login_clear)

        loginPresenter = LoginPresenterCompl(this)
        loginPresenter?.setProgressBarVisiblity(View.INVISIBLE)

        btnClear.setOnClickListener {
            loginPresenter?.clear()
        }
        btnLogin.setOnClickListener {
            loginPresenter?.setProgressBarVisiblity(View.VISIBLE)
            btnLogin.isEnabled = false
            btnClear.isEnabled = false
            loginPresenter?.doLogin(editUser.text.toString(), editPass.text.toString())
        }
    }

    override fun onClearText() {
        val editUser : EditText = et_login_username
        editUser.setText("")
        val editPass : EditText = et_login_password
        editPass.setText("")
    }

    override fun onLoginResult(result: Boolean, code: Int) {
        loginPresenter?.setProgressBarVisiblity(View.INVISIBLE)
        val btnLogin : Button = btn_login_login
        val btnClear : Button = btn_login_clear
        btnLogin.isEnabled = true
        btnClear.isEnabled = true
        if (result){
            Toast.makeText(this,"Login Success",Toast.LENGTH_SHORT).show()
        }
        else
            Toast.makeText(this,"Login Fail, code = " + code,Toast.LENGTH_SHORT).show()
    }



    override fun onSetProgressBarVisibility(visibility: Int) {
        val progressBar : ProgressBar = progress_login
        progressBar.visibility = visibility
    }


}
