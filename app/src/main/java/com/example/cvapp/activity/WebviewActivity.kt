package com.example.cvapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PatternMatcher
import android.util.Patterns
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import android.widget.SearchView
import com.example.cvapp.databinding.ActivityWebviewBinding
import java.util.regex.Pattern

class WebviewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWebviewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebviewBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val url = intent.getStringExtra("url") ?: ""
        binding.webview.webViewClient = WebViewClient()
        binding.webview.settings.javaScriptEnabled = true
        binding.webview.settings.builtInZoomControls = true
        binding.webview.loadUrl(url)

//        binding.btnFwd.setOnClickListener {
//            binding.webview.goForward()
//        }
//
//        binding.btnBack.setOnClickListener {
//            binding.webview.goBack()
//        }

//        binding.edtSearch.setOnQueryTextListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener {
//            override fun onQueryTextSubmit(query: String?): Boolean {
//                val url = query?.let {
//                    //if (Patterns.WEB_URL.matcher(url).matches()) {
//                        binding.webview.loadUrl("http://$it")
//                    //}
//                } ?: run {
//                    binding.webview.loadUrl("http://www.google.com")
//                }
//                return true
//            }
//
//            override fun onQueryTextChange(newText: String): Boolean {
//                return true
//            }
//        })

    }




}