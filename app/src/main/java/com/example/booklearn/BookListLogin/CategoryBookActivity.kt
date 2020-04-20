package com.example.booklearn.BookListLogin

import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.booklearn.ActivityContainFragment
import com.example.booklearn.JsonModel.Genres
import com.example.booklearn.JsonModel.JsonElement
import com.example.booklearn.UpdateAdapter
import com.example.learnbook.R
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import java.io.IOException


/* Активность должна выполнять:
    *Транзакцию фрагментов
    *Добавление данных в JSON и чтения из него
    *Его фрагменты должны поддерживать обновление списка ресайкл
 */
class CategoryBookActivity : AppCompatActivity(),
    ActivityContainFragment, JsonParseListBook, UpdateAdapter  {
    private lateinit var settings: SharedPreferences
    private val LOG_STATE_TRANS_FR = "Fragment state change"
    private var mainFragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_book)

        mainFragment = GenresListFragment()
        val containerFragment: Int = R.id.fr_container_book_list
        addFragment(containerFragment, mainFragment!!)
    }

    override fun getFragment(): Fragment? {
        return mainFragment
    }

    override fun replaceFragment(frCont: Int, fr: Fragment) {
        supportFragmentManager.beginTransaction().replace(frCont, fr).commit()
        Log.d(LOG_STATE_TRANS_FR,"replace Fragment")
    }

    override fun addFragment(frCont: Int, fr: Fragment) {
        supportFragmentManager.beginTransaction().add(frCont, fr).commit()
        Log.d(LOG_STATE_TRANS_FR, "add Fragment")
    }

    override fun removeFragment(fr: Fragment) {

    }


    override fun getJsonElements(parent: String?): List<JsonElement>? {
        val textJson = getAssetsText("Book.json")
        val gson = GsonBuilder().create()
        return gson.fromJson<List<Genres>?>(textJson,  object : TypeToken<List<Genres>>() {}.type)
    }

    override fun saveJsonElement(parent: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    private fun getAssetsText(filename:String): String?{
        return try {
            val isr = assets.open(filename)
            val buffer = ByteArray(isr.available())
            isr.read(buffer)
            isr.close()
            String(buffer)
        } catch (e: IOException) {
            e.printStackTrace()
            null
        }
    }

    override fun updateList(listItem: List<JsonElement>, position: Int): List<JsonElement> {
        TODO("Not yet implemented")
    }


}
