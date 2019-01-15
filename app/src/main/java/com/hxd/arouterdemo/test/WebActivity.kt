package com.hxd.arouterdemo.test

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Route
import com.hxd.arouterdemo.R
import com.hxd.arouterdemo.path2WebActivity
import kotlinx.android.synthetic.main.activity_web.*

@Route(path = path2WebActivity)
class WebActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)

        webView.loadUrl("file:///android_asset/schame-test.html")
    }

}
