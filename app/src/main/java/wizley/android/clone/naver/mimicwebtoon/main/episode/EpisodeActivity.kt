package wizley.android.clone.naver.mimicwebtoon.main.episode

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_episode.view.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.jsoup.Jsoup
import wizley.android.clone.naver.mimicwebtoon.R
import wizley.android.clone.naver.mimicwebtoon.databinding.ActivityEpisodeBinding
import wizley.android.clone.naver.mimicwebtoon.main.MainActivity
import wizley.android.clone.naver.mimicwebtoon.more.MoreActivity

class EpisodeActivity: AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityEpisodeBinding
    private lateinit var rvAdapter: EpisodeRVAdapter
    private lateinit var rvManager: RecyclerView.LayoutManager
    private var name: String? = null
    private var serial: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityEpisodeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initArgumentInfo()
        initActionBar()
        initGnbBar()
        initRecyclerView()
    }

    private fun initArgumentInfo(){
        name = intent.extras?.getString("name", null)
        if(name != null){
            binding.toolbar.title = name
        } else {
            finish()
        }

        serial = intent.extras?.getString("serial")
        serial?.let {
            parseEpisodeList(it)
        }

    }

    private fun initActionBar(){
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_baseline_chevron_left_24)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowCustomEnabled(true)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.webtoon, menu)
        return true
    }

    private fun initGnbBar(){
        binding.gnbBar.itemIconTintList = null
        binding.gnbBar.setOnNavigationItemSelectedListener(this)

        setGnbColor()
    }

    private fun setGnbColor(){
        val selected = binding.gnbBar.selectedItemId
        val selectedMenu = binding.gnbBar.menu.findItem(selected)
        when(selectedMenu.itemId){
            R.id.menu_gnb_webtoon -> {
                selectedMenu.setIcon(R.drawable.menu_gnb_webtoon_on)
            }
            R.id.menu_gnb_recommend -> {
                selectedMenu.setIcon(R.drawable.menu_gnb_recommendfinish_on)
            }
            R.id.menu_gnb_bestchallenge -> {
                selectedMenu.setIcon(R.drawable.menu_gnb_bestchallenge_on)
            }
            R.id.menu_gnb_my -> {
                selectedMenu.setIcon(R.drawable.menu_gnb_my_on)
            }
            R.id.menu_gnb_more -> {
                selectedMenu.setIcon(R.drawable.menu_gnb_more_on)
            }
        }
    }

    override fun onNavigationItemSelected(menu: MenuItem): Boolean {
        when(menu.itemId){
            R.id.menu_gnb_webtoon -> {
                val intent = Intent(this, MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP or Intent.FLAG_ACTIVITY_CLEAR_TOP
                startActivity(intent)
                finish()
            }
            R.id.menu_gnb_recommend -> {

            }
            R.id.menu_gnb_bestchallenge -> {

            }
            R.id.menu_gnb_my -> {

            }
            R.id.menu_gnb_more -> {
                val intent = Intent(this, MoreActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP or Intent.FLAG_ACTIVITY_CLEAR_TOP
                startActivity(intent)
            }
        }
        return false
    }

    private fun initRecyclerView(){
        rvAdapter = EpisodeRVAdapter(
            this,
            ArrayList<EpisodeInfo>()
        )
        rvManager = LinearLayoutManager(this)

        runOnUiThread{
            binding.root.rv.apply {
                layoutManager = rvManager
                adapter = rvAdapter
            }
            rvAdapter.notifyDataSetChanged()
        }
    }

    private fun parseEpisodeList(no: String){
        val arrayList = ArrayList<EpisodeInfo>()
        CoroutineScope(Dispatchers.Default).launch{
            var page = 1
            var pos = "0"
            while(pos != "1") {
                val doc =
                    Jsoup.connect("https://comic.naver.com/webtoon/list.nhn?titleId=$no&page=$page").get()
                val elements = doc.select("tr")

                elements.forEachIndexed { index, elem ->
                    val img = elem.select("td a img").attr("src")
                    val title = elem.select("td a img").attr("title")
                    val rate = elem.select("div.rating_type strong").text()
                    val date = elem.select("td.num").text()

                    if (img.isNotEmpty() and title.isNotEmpty() and rate.isNotEmpty()) {
                        pos = elem.select("td.title a").attr("href").toString()
                            .split("&no=", "&weekday")[1]
                        arrayList.add(EpisodeInfo(title, img, rate, date))
                    }
                }
                page++
            }

            rvAdapter.episodes = arrayList

            CoroutineScope(Dispatchers.Main).launch {
                rvAdapter.notifyDataSetChanged()
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> {
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }

}