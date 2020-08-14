package wizley.android.clone.naver.mimicwebtoon.main

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.NestedScrollView
import kotlinx.android.synthetic.main.test.*
import wizley.android.clone.naver.mimicwebtoon.R
import wizley.android.clone.naver.mimicwebtoon.databinding.TestBinding

class TestActivity: AppCompatActivity(), NestedScrollView.OnScrollChangeListener{

    private lateinit var binding: TestBinding

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = TestBinding.inflate(layoutInflater)
        setContentView(binding.root)

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
        } else {
            supportActionBar?.show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.appbar, menu)
        return true
    }

}