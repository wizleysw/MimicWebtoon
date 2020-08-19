package wizley.android.clone.naver.mimicwebtoon.more.notice

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.webkit.WebViewClient
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import wizley.android.clone.naver.mimicwebtoon.R
import wizley.android.clone.naver.mimicwebtoon.databinding.ActivityNoticeBinding

class NoticeActivity: AppCompatActivity() {

    private lateinit var binding: ActivityNoticeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNoticeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initActionBar()
        popUpWebView()
    }

    private fun initActionBar(){
        binding.toolbar.title = "공지사항::네이버웹툰"
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_baseline_close_24)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowCustomEnabled(true)
    }

    private fun popUpWebView(){
        binding.webView.webViewClient = WebViewClient()
        binding.webView.loadUrl("https://m.comic.naver.com/notice/list.nhn")
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> {
                finish()
            }
            R.id.overflow_copy -> {
                val url = binding.webView.url
                if(android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.HONEYCOMB){
                    val clipboard: android.text.ClipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as android.text.ClipboardManager
                    clipboard.text = url
                } else {
                    val clipboard: android.content.ClipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as android.content.ClipboardManager
                    val clip: android.content.ClipData = android.content.ClipData.newPlainText("mimicWebtoon", url)
                    clipboard.setPrimaryClip(clip)
                }
                Toast.makeText(this, "클립보드로 복사했습니다", Toast.LENGTH_LONG).show()
            }
            R.id.overflow_share -> {
                val intent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, binding.webView.url)
                    type = "text/plain"
                }
                startActivity(intent)
            }
            R.id.overflow_internet -> {
                val intent = Intent().apply {
                    action = Intent.ACTION_VIEW
                    data = Uri.parse(binding.webView.url)
                }
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.notice, menu)
        return true
    }
}