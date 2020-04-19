package com.example.booklearn.AuthLogin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.booklearn.ActivityChange
import com.example.booklearn.JsonAuthorization
import com.example.booklearn.JsonModel.User

import com.example.learnbook.R

/**
 * A simple [Fragment] subclass.
 */
class AuthFragment : Fragment(), View.OnClickListener {
    private lateinit var mBtnReg: Button
    private lateinit var mBtnLogIn: Button
    private lateinit var mEditLogin: EditText
    private lateinit var mEditPassword: EditText
    private lateinit var jsonAuth: JsonAuthorization
    private lateinit var activityTrans: ActivityChange
    private var userList: List<User>? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v: View = inflater.inflate(R.layout.fragment_auth, container, false)
        mBtnLogIn = v.findViewById(R.id.btn_loginIn)
        mBtnReg = v.findViewById(R.id.btn_reg)
        mEditLogin = v.findViewById(R.id.edit_login)
        mEditPassword = v.findViewById(R.id.edit_password)

        jsonAuth = activity as JsonAuthorization
        activityTrans = activity as ActivityChange
        userList = jsonAuth.getListUserJson()

        mBtnLogIn.setOnClickListener(this)
        mBtnReg.setOnClickListener(this)
        return v
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_loginIn -> {
                loginIn()
            }
            R.id.btn_reg -> {
                regUser()
            }
        }
    }

    private fun loginIn() {
        val loginU = mEditLogin.text.toString()
        val password = mEditPassword.text.toString()
        if (isLoginInList(loginU)) {
            userList!!.any {(it.login == loginU) && (it.password == password)}
            //Уходим на другую активность и сохраняем состояние в SharPref
            activityTrans.goNewActivity(loginU)
        } else {
            Toast.makeText(
                activity!!.applicationContext, "Ошибка авторизации",
                Toast.LENGTH_LONG
            ).show()
        }

    }

    private fun regUser() {
        val loginU = mEditLogin.text.toString()
        val password = mEditPassword.text.toString()
        if (!isLoginInList(loginU) && isPasswordValid(password)) {
            val newUser = User(loginU, password)
            jsonAuth.saveNewUser(userList, newUser)
            userList = jsonAuth.getListUserJson()
        } else {
            Toast.makeText(
                activity!!.applicationContext,
                "Логин занят или пароль не соответствует требованием", Toast.LENGTH_LONG
            ).show()
        }
    }


    //Проверяем, есть ли пользователь в списке
    private fun isLoginInList(loginU: String): Boolean {
        if (userList != null) {
            return userList!!.any {it.login == loginU}
        }
        return false
    }

    //Проверяем, хороший ли пароль
    private fun isPasswordValid(password: String): Boolean {
        return password.length >= 4
    }


}
