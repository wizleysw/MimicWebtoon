package wizley.android.clone.naver.mimicwebtoon.more.settings.autoplay

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import wizley.android.clone.naver.mimicwebtoon.R
import wizley.android.clone.naver.mimicwebtoon.databinding.ActivitySettingsBinding
import wizley.android.clone.naver.mimicwebtoon.more.settings.SettingsFragment

class AutoplaySettingsActivity: AppCompatActivity(){

    private lateinit var binding: ActivitySettingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initFragment()
        initActionBar()
    }

    private fun initFragment(){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment, SettingsFragment(R.xml.autoplay_settings))
            .commit()

    }

    private fun initActionBar(){
        binding.toolbar.title = "동영상 자동 재생"
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_baseline_chevron_left_24)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowCustomEnabled(true)
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