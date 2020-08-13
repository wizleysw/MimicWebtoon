package wizley.android.clone.naver.mimicwebtoon.main

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.NestedScrollView
import kotlinx.android.synthetic.main.test.*
import wizley.android.clone.naver.mimicwebtoon.databinding.TestBinding

class TestActivity: AppCompatActivity(), NestedScrollView.OnScrollChangeListener{

    private lateinit var binding: TestBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = TestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.hide()

        binding.scrollview.setOnScrollChangeListener(this)
    }

    override fun onStart() {
        super.onStart()

        supportActionBar?.show()
    }

    override fun onResume() {
        super.onResume()

        supportActionBar?.hide()
    }

    override fun onScrollChange(
        v: NestedScrollView?,
        scrollX: Int,
        scrollY: Int,
        oldScrollX: Int,
        oldScrollY: Int
    ) {
        if(scrollY == 0){
            Log.e("TAG", "hide")
            Log.e("TAG", supportActionBar.toString())
            runOnUiThread(Runnable{
                supportActionBar?.hide()
            })
            supportActionBar?.hide()
            supportActionBar?.hide()
            supportActionBar?.hide()
            Log.e("TAG", supportActionBar!!.isShowing.toString())
        }
        else {
            Log.e("TAG", "show")
            supportActionBar?.show()
            Log.e("TAG", supportActionBar!!.isShowing.toString())
        }
    }

}