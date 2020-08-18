package wizley.android.clone.naver.mimicwebtoon.more

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import wizley.android.clone.naver.mimicwebtoon.R
import wizley.android.clone.naver.mimicwebtoon.databinding.ActivityMoreBinding

class MoreActivity: AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityMoreBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMoreBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initActionBar()
        initGnbBar()
    }

    private fun initActionBar(){
        binding.toolbar.title = "더보기"
        setSupportActionBar(binding.toolbar)

        supportActionBar?.setDisplayShowHomeEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        supportActionBar?.setDisplayShowCustomEnabled(true)

    }

    private fun initGnbBar(){
        binding.gnbBar.itemIconTintList = null
        binding.gnbBar.setOnNavigationItemSelectedListener(this)
        binding.gnbBar.selectedItemId = R.id.menu_gnb_more
        setGnbColor()
    }

    private fun setGnbColor(){
        val selectedMenu = binding.gnbBar.menu.findItem(R.id.menu_gnb_more)
        selectedMenu.setIcon(R.drawable.menu_gnb_more_on)
    }

    override fun onNavigationItemSelected(menu: MenuItem): Boolean {
        when(menu.itemId){
            R.id.menu_gnb_webtoon -> {

            }
            R.id.menu_gnb_recommend -> {

            }
            R.id.menu_gnb_bestchallenge -> {

            }
            R.id.menu_gnb_my -> {

            }
            R.id.menu_gnb_more -> {

            }
        }
        return false
    }

}