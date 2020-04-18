package com.example.booklearn.AuthLogin


import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.booklearn.ActivityChange
import com.example.booklearn.ActivityContainFragment
import com.example.booklearn.BookListLogin.CategoryBookActivity
import com.example.booklearn.JsonAuthorization
import com.example.booklearn.JsonModel.User
import com.example.learnbook.R
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import java.io.*
import java.lang.reflect.Type


class LoginActivity : AppCompatActivity(), ActivityContainFragment,
    JsonAuthorization, ActivityChange {
    private lateinit var frTrans: FragmentTransaction
    private val LOG_STATE_TRANS_FR = "Fragment state change"
    private var mainFragment: Fragment? = null
    private val USER_FILE = "user.json"
    private val USER_PREF_FILE = "Account"
    private val PREF_LOGIN = "login"
    private lateinit var settings: SharedPreferences


    private fun authCheck(){
        if (settings.getString(PREF_LOGIN, "") != ""){
            val intent = Intent(this, CategoryBookActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        settings = getSharedPreferences(USER_PREF_FILE, Context.MODE_PRIVATE)
        authCheck()
        frTrans = supportFragmentManager.beginTransaction()
        mainFragment = AuthFragment()
        val containerFragment: Int = R.id.fragment_container_view
        addFragment(containerFragment, mainFragment!!)

    }


    override fun getFragment(): Fragment {
        TODO()
    }

    override fun replaceFragment(frCont: Int, fr: Fragment) {
        frTrans.replace(frCont, fr).commit()
        Log.d(LOG_STATE_TRANS_FR,"replace Fragment")
    }

    override fun addFragment(frCont: Int, fr: Fragment) {
        frTrans.add(frCont, fr).commit()
        Log.d(LOG_STATE_TRANS_FR, "add Fragment")
    }

    override fun removeFragment(fr: Fragment) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getListUserJson(): List<User>? {
        try {
            val itemsListType: Type =
                object : TypeToken<List<User>?>() {}.type
            val isr = InputStreamReader(openFileInput(USER_FILE))
            val reader = BufferedReader(isr)
            var jsonText: String?
            val builder: StringBuilder = StringBuilder()
            do {
                jsonText = reader.readLine()
                if (jsonText == null)
                    break
                builder.append("${jsonText}\n")
            } while (true)
            isr.close()
            val gson = GsonBuilder().create()
            val js: List<User>? = gson.fromJson(builder.toString(), itemsListType)
            return js
        }catch (e: FileNotFoundException){
            Toast.makeText(applicationContext, e.message, Toast.LENGTH_LONG).show()
        }
        Toast.makeText(applicationContext, "Опасность", Toast.LENGTH_LONG).show()
        return null
    }

    override fun saveNewUser(userList: List<User>? , user: User) {
        val newUserList: List<User> =
            if (userList != null) {
            listOf(userList, listOf(user)).flatten()
            }
            else {
                listOf(user)
            }
        val gson = GsonBuilder().create()
        val jsonFile: String = gson.toJson(newUserList)
        try {
            val outputStream: OutputStream = openFileOutput(USER_FILE, 0)
            val osw = OutputStreamWriter(outputStream)
            osw.write(jsonFile)
            osw.close()
        }catch (e: FileNotFoundException){
            Toast.makeText(applicationContext,
                "${e.message} Файл не найден", Toast.LENGTH_LONG).show()
        }catch (e: IOException){
            Toast.makeText(applicationContext, e.message, Toast.LENGTH_LONG).show()
        }
    }

    //Сохранения состояния
    override fun goNewActivity(login: String) {
        val prefEditor: Editor = settings.edit()
        prefEditor.putString(PREF_LOGIN, "").apply()
        val intent = Intent(this, CategoryBookActivity::class.java)
        startActivity(intent)
    }


}
