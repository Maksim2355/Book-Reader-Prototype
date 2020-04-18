package com.example.booklearn.BookListLogin

import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.booklearn.ActivityChange
import com.example.booklearn.ActivityContainFragment
import com.example.booklearn.JsonModel.JsonElement
import com.example.booklearn.UpdateAdapter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException
import java.lang.reflect.Type


/* Активность должна выполнять:
    *Транзакцию фрагментов
    *Добавление данных в JSON и чтения из него
    *Его фрагменты должны поддерживать обновление списка ресайкл
 */
class CategoryBookActivity : AppCompatActivity(), ActivityContainFragment,
    ActivityChange, JsonParseListBook, UpdateAdapter  {
    private lateinit var settings: SharedPreferences
    private lateinit var frTrans: FragmentTransaction
    private val LOG_STATE_TRANS_FR = "Fragment state change"
    private var mainFragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_book)
        frTrans = supportFragmentManager.beginTransaction()
        mainFragment = GenresListFragment()
        val containerFragment: Int = R.id.fr_container_book_list
        addFragment(containerFragment, mainFragment!!)
    }

    override fun getFragment(): Fragment {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
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

    override fun goNewActivity(login: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun updateList() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getJsonElements(parent: String?): List<JsonElement>? {
        val text: String = "Book.json"
        var buffer: ByteArray? = null
        try {
            val isr = assets.open(text)
            val size: Int = isr.available()
            buffer = ByteArray(size)
            isr.read(buffer)
            isr.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        val str_data = String(buffer!!)
        val itemsListType: Type =
            object : TypeToken<List<JsonElement>?>() {}.type
        val gson = Gson()
        if (parent == null){

        }
        val vs: List<Ge>
        return
    }

    override fun saveJsonElement(parent: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}
