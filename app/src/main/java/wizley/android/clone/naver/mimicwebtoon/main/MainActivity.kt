package wizley.android.clone.naver.mimicwebtoon.main

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.Rect
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.view.isVisible
import androidx.core.widget.NestedScrollView
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.test.*
import org.w3c.dom.Text
import wizley.android.clone.naver.mimicwebtoon.R
import wizley.android.clone.naver.mimicwebtoon.databinding.ActivityMainBinding
import wizley.android.clone.naver.mimicwebtoon.databinding.TestBinding

class MainActivity: AppCompatActivity(), NestedScrollView.OnScrollChangeListener, BottomNavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    private lateinit var pager: WrapHeightViewPager
    private lateinit var currentPage: TextView
    private lateinit var currentPageAppbar: TextView

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initActionBar()
        initImageBanner()
        initGnbBar()
        initPager()

    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()

    }

    override fun onScrollChange(
        v: NestedScrollView?,
        scrollX: Int,
        scrollY: Int,
        oldScrollX: Int,
        oldScrollY: Int
    ) {
        if(scrollY == 0){
            supportActionBar?.hide()
            hideImageBanner()
        } else {
            setButtonBar()

            supportActionBar?.show()
            showImageBanner()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.appbar, menu)
        return true
    }

    private fun initActionBar(){
        setSupportActionBar(binding.toolbar)
        supportActionBar?.hide()

        val toolbar = layoutInflater.inflate(R.layout.custom_actionbar, null)
        supportActionBar?.customView = toolbar
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayShowHomeEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        supportActionBar?.setDisplayShowCustomEnabled(true)

        binding.scrollview.setOnScrollChangeListener(this)
    }

    private fun initImageBanner(){
        hideImageBanner()
    }

    private fun showImageBanner(){
        binding.imageBanner.visibility = View.VISIBLE

        val constraintSet = ConstraintSet()
        constraintSet.clone(binding.constraintLayout)
        constraintSet.connect(binding.scrollview.id, ConstraintSet.BOTTOM, binding.imageBanner.id, ConstraintSet.TOP)
        constraintSet.connect(binding.imageBanner.id, ConstraintSet.TOP, binding.scrollview.id, ConstraintSet.BOTTOM)
        constraintSet.connect(binding.imageBanner.id, ConstraintSet.BOTTOM, binding.gnbBar.id, ConstraintSet.TOP)
        constraintSet.connect(binding.gnbBar.id, ConstraintSet.TOP, binding.imageBanner.id, ConstraintSet.BOTTOM)

        constraintSet.applyTo(binding.constraintLayout)
    }

    private fun hideImageBanner(){
        binding.imageBanner.visibility = View.GONE

        val constraintSet = ConstraintSet()
        constraintSet.clone(binding.constraintLayout)
        constraintSet.connect(binding.scrollview.id, ConstraintSet.BOTTOM, binding.gnbBar.id, ConstraintSet.TOP)
        constraintSet.connect(binding.gnbBar.id, ConstraintSet.TOP, binding.scrollview.id, ConstraintSet.BOTTOM)

        constraintSet.applyTo(binding.constraintLayout)
    }

    private fun initGnbBar(){
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

    private fun initPagerAppBar(){

        currentPageAppbar = binding.pagerBarBynLayoutAppbar.pagerBarNew
        binding.pagerBarBynLayoutAppbar.pagerBarNewBg.setBackgroundColor(Color.rgb(4, 206, 92))
        binding.pagerBarBynLayoutAppbar.pagerBarNew.setTextColor(Color.WHITE)

        binding.pagerBarBynLayoutAppbar.pagerBarNew.setOnClickListener(this)
        binding.pagerBarBynLayoutAppbar.pagerBarMon.setOnClickListener(this)
        binding.pagerBarBynLayoutAppbar.pagerBarTue.setOnClickListener(this)
        binding.pagerBarBynLayoutAppbar.pagerBarWed.setOnClickListener(this)
        binding.pagerBarBynLayoutAppbar.pagerBarThu.setOnClickListener(this)
        binding.pagerBarBynLayoutAppbar.pagerBarFri.setOnClickListener(this)
        binding.pagerBarBynLayoutAppbar.pagerBarSat.setOnClickListener(this)
        binding.pagerBarBynLayoutAppbar.pagerBarSun.setOnClickListener(this)
        binding.pagerBarBynLayoutAppbar.pagerBarFin.setOnClickListener(this)
    }

    private fun initPagerBar(){
        currentPage = binding.pagerBarBtnLayout.pagerBarNew

        binding.pagerBarBtnLayout.pagerBarNewBg.setBackgroundColor(Color.rgb(4, 206, 92))
        binding.pagerBarBtnLayout.pagerBarNew.setTextColor(Color.WHITE)

        binding.pagerBarBtnLayout.pagerBarNew.setOnClickListener(this)
        binding.pagerBarBtnLayout.pagerBarMon.setOnClickListener(this)
        binding.pagerBarBtnLayout.pagerBarTue.setOnClickListener(this)
        binding.pagerBarBtnLayout.pagerBarWed.setOnClickListener(this)
        binding.pagerBarBtnLayout.pagerBarThu.setOnClickListener(this)
        binding.pagerBarBtnLayout.pagerBarFri.setOnClickListener(this)
        binding.pagerBarBtnLayout.pagerBarSat.setOnClickListener(this)
        binding.pagerBarBtnLayout.pagerBarSun.setOnClickListener(this)
        binding.pagerBarBtnLayout.pagerBarFin.setOnClickListener(this)
    }

    private fun initPager(){
        pager = binding.viewPager
        pager.setPageTransformer(true, ViewPagerTransformer())

        val pagerAdapter = ViewPagerAdapter(supportFragmentManager)
        pager.adapter = pagerAdapter
        pagerAdapter.notifyDataSetChanged()
        pager.currentItem = 0

        initPagerBar()
        initPagerAppBar()
    }

    private fun setPagerBar(view: TextView, appbarView: TextView){
        if(view.id == currentPage.id) return

        if(view.id == R.id.pager_bar_new){
            binding.pagerBarBtnLayout.pagerBarNewBg.setBackgroundColor(Color.rgb(4, 206, 92))
            binding.pagerBarBynLayoutAppbar.pagerBarNewBg.setBackgroundColor(Color.rgb(4, 206, 92))
        } else {
            view.setBackgroundColor(Color.rgb(4, 206, 92))
            appbarView.setBackgroundColor(Color.rgb(4, 206, 92))
        }
        view.setTextColor(Color.WHITE)
        appbarView.setTextColor(Color.WHITE)

        if(currentPage.id == R.id.pager_bar_new){
            binding.pagerBarBtnLayout.pagerBarNewBg.setBackgroundColor(Color.WHITE)
            binding.pagerBarBynLayoutAppbar.pagerBarNewBg.setBackgroundColor(Color.WHITE)
        } else {
            currentPage.setBackgroundColor(Color.WHITE)
            currentPageAppbar.setBackgroundColor(Color.WHITE)
        }
        currentPage.setTextColor(Color.BLACK)
        currentPageAppbar.setTextColor(Color.BLACK)

        currentPage = view
        currentPageAppbar = appbarView
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.pager_bar_new -> {
                setPagerBar(binding.pagerBarBtnLayout.pagerBarNew, binding.pagerBarBynLayoutAppbar.pagerBarNew)
                pager.currentItem = 0
            }
            R.id.pager_bar_mon -> {
                setPagerBar(binding.pagerBarBtnLayout.pagerBarMon, binding.pagerBarBynLayoutAppbar.pagerBarMon)
                pager.currentItem = 1
            }
            R.id.pager_bar_tue -> {
                setPagerBar(binding.pagerBarBtnLayout.pagerBarTue, binding.pagerBarBynLayoutAppbar.pagerBarTue)
                pager.currentItem = 2
            }
            R.id.pager_bar_wed -> {
                setPagerBar(binding.pagerBarBtnLayout.pagerBarWed, binding.pagerBarBynLayoutAppbar.pagerBarWed)
                pager.currentItem = 3
            }
            R.id.pager_bar_thu -> {
                setPagerBar(binding.pagerBarBtnLayout.pagerBarThu, binding.pagerBarBynLayoutAppbar.pagerBarThu)
                pager.currentItem = 4
            }
            R.id.pager_bar_fri -> {
                setPagerBar(binding.pagerBarBtnLayout.pagerBarFri, binding.pagerBarBynLayoutAppbar.pagerBarFri)
                pager.currentItem = 5
            }
            R.id.pager_bar_sat -> {
                setPagerBar(binding.pagerBarBtnLayout.pagerBarSat, binding.pagerBarBynLayoutAppbar.pagerBarSat)
                pager.currentItem = 6
            }
            R.id.pager_bar_sun -> {
                setPagerBar(binding.pagerBarBtnLayout.pagerBarSun, binding.pagerBarBynLayoutAppbar.pagerBarSun)
                pager.currentItem = 7
            }
            R.id.pager_bar_fin -> {
                setPagerBar(binding.pagerBarBtnLayout.pagerBarFin, binding.pagerBarBynLayoutAppbar.pagerBarFin)
                pager.currentItem = 8
            }
        }
    }

    private fun setButtonBar(){
        val constraintSet = ConstraintSet()
        constraintSet.clone(binding.scrollViewConstraintLayout)

        if(isTopBannerVisible()){
            binding.pagerBarBynLayoutAppbar.pagerBarBtnLayout.visibility = View.GONE
        } else {
            binding.pagerBarBynLayoutAppbar.pagerBarBtnLayout.visibility = View.VISIBLE
        }
        constraintSet.applyTo(binding.scrollViewConstraintLayout)
    }

    private fun isTopBannerVisible() : Boolean{
        val scrollBounds = Rect()
        binding.scrollview.getHitRect(scrollBounds)
        return binding.topBanner.getLocalVisibleRect(scrollBounds)
    }

}