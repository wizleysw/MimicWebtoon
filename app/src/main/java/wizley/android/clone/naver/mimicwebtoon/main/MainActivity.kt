package wizley.android.clone.naver.mimicwebtoon.main

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.viewpager.widget.ViewPager
import com.google.android.material.bottomnavigation.BottomNavigationView
import wizley.android.clone.naver.mimicwebtoon.R
import wizley.android.clone.naver.mimicwebtoon.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
//    private lateinit var pager: ViewPager
    private lateinit var pager: WrapHeightViewPager
    private lateinit var currentPage: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.gnbBar.itemIconTintList = null
        binding.gnbBar.setOnNavigationItemSelectedListener(this)

        setGnbColor()
        setPager()
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

    private fun setPager(){
        pager = binding.viewPager
        pager.setPageTransformer(true, ViewPagerTransformer())

        val pagerAdapter = ViewPagerAdapter(supportFragmentManager)
        pager.adapter = pagerAdapter
        pager.currentItem = 0

        currentPage = binding.pagerBarNew

        binding.pagerBarNewBg.setBackgroundColor(Color.rgb(4, 206, 92))
        binding.pagerBarNew.setTextColor(Color.WHITE)

        binding.pagerBarNew.setOnClickListener(this)
        binding.pagerBarMon.setOnClickListener(this)
        binding.pagerBarTue.setOnClickListener(this)
        binding.pagerBarWed.setOnClickListener(this)
        binding.pagerBarThu.setOnClickListener(this)
        binding.pagerBarFri.setOnClickListener(this)
        binding.pagerBarSat.setOnClickListener(this)
        binding.pagerBarSun.setOnClickListener(this)
        binding.pagerBarFin.setOnClickListener(this)
    }

    private fun setPagerBar(view: TextView){
        if(view.id == currentPage.id) return

        if(view.id == R.id.pager_bar_new){
            binding.pagerBarNewBg.setBackgroundColor(Color.rgb(4, 206, 92))
        } else {
            view.setBackgroundColor(Color.rgb(4, 206, 92))
        }
        view.setTextColor(Color.WHITE)

        if(currentPage.id == R.id.pager_bar_new){
            binding.pagerBarNewBg.setBackgroundColor(Color.WHITE)
        } else {
            currentPage.setBackgroundColor(Color.WHITE)
        }
        currentPage.setTextColor(Color.BLACK)

        currentPage = view
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.pager_bar_new -> {
                setPagerBar(binding.pagerBarNew)
                pager.currentItem = 0
            }
            R.id.pager_bar_mon -> {
                setPagerBar(binding.pagerBarMon)
                pager.currentItem = 1
            }
            R.id.pager_bar_tue -> {
                setPagerBar(binding.pagerBarTue)
                pager.currentItem = 2
            }
            R.id.pager_bar_wed -> {
                setPagerBar(binding.pagerBarWed)
                pager.currentItem = 3
            }
            R.id.pager_bar_thu -> {
                setPagerBar(binding.pagerBarThu)
                pager.currentItem = 4
            }
            R.id.pager_bar_fri -> {
                setPagerBar(binding.pagerBarFri)
                pager.currentItem = 5
            }
            R.id.pager_bar_sat -> {
                setPagerBar(binding.pagerBarSat)
                pager.currentItem = 6
            }
            R.id.pager_bar_sun -> {
                setPagerBar(binding.pagerBarSun)
                pager.currentItem = 7
            }
            R.id.pager_bar_fin -> {
                setPagerBar(binding.pagerBarFin)
                pager.currentItem = 8
            }
        }
    }
}