package wizley.android.clone.naver.mimicwebtoon.main

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log

import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.jsoup.Jsoup
import kotlin.coroutines.CoroutineContext

class TestActivity: AppCompatActivity(){
    private val TAG = "TEST"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        parseEpisodeList("651673")

    }

    private fun parseWebtoonList(day: String){
        CoroutineScope(Dispatchers.Default).launch{
            val doc = Jsoup.connect("https://comic.naver.com/webtoon/weekdayList.nhn?week=$day").get()
            val elements = doc.select("ul.img_list li")

            elements.forEachIndexed{index, elem ->
                val no = elem.select("a").attr("href").split("titleId=", "&weekday")[1]
                val title = elem.select("a").attr("title")
                val img = elem.select("img").attr("src")
                val author = elem.select("dd.desc a").text()
                val star = elem.select("div.rating_type strong").text()

                Log.e(TAG, "-------------------")
                Log.e(TAG, no)
                Log.e(TAG, title)
                Log.e(TAG, img)
                Log.e(TAG, author)
                Log.e(TAG, star)
            }
        }
    }

    private fun parseEpisodeList(no: String){
        CoroutineScope(Dispatchers.Default).launch{
            val doc = Jsoup.connect("https://comic.naver.com/webtoon/list.nhn?titleId=$no").get()
            val elements =  doc.select("tr")

            elements.forEachIndexed{index, elem ->
                val img = elem.select("td a img").attr("src")
                val title = elem.select("td a img").attr("title")
                val rate =  elem.select("div.rating_type strong").text()

                if(img.isNotEmpty() and title.isNotEmpty() and rate.isNotEmpty()) {
                    Log.e(TAG, img)
                    Log.e(TAG, title)
                    Log.e(TAG, rate)
                }
            }
        }
    }
}