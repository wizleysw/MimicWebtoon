package wizley.android.clone.naver.mimicwebtoon.more

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import wizley.android.clone.naver.mimicwebtoon.R
import wizley.android.clone.naver.mimicwebtoon.databinding.ActivityMoreBinding
import wizley.android.clone.naver.mimicwebtoon.main.MainActivity
import wizley.android.clone.naver.mimicwebtoon.more.notice.NoticeActivity
import wizley.android.clone.naver.mimicwebtoon.more.settings.SettingsActivity

class MoreActivity: AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener,
    View.OnClickListener {

    private lateinit var binding: ActivityMoreBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMoreBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initActionBar()
        initGnbBar()
        initGridButton()
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
                val intent = Intent(this, MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP or Intent.FLAG_ACTIVITY_CLEAR_TOP
                startActivity(intent)
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

    private fun initGridButton(){
        binding.noticeButton.setOnClickListener(this)
        binding.settingButton.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.notice_button -> {
                val intent = Intent(this, NoticeActivity::class.java)
                startActivity(intent)
            }
            R.id.setting_button -> {
                val intent = Intent(this, SettingsActivity::class.java)
                startActivity(intent)
            }
        }
    }

}