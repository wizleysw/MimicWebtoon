package wizley.android.clone.naver.mimicwebtoon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import androidx.core.view.forEach
import com.google.android.material.bottomnavigation.BottomNavigationView
import wizley.android.clone.naver.mimicwebtoon.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.gnbBar.itemIconTintList = null
        binding.gnbBar.setOnNavigationItemSelectedListener(this)

        setGnbColor()
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

    fun setGnbColor(){
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
}