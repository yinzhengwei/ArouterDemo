package com.hxd.arouterdemo.test

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.hxd.arouterdemo.R
import com.hxd.arouterdemo.path2InterceptorTestActivity
import kotlinx.android.synthetic.main.activity_interceptor_test.*

/**
 * 拦截器测试Activity
 */

@Route(path = path2InterceptorTestActivity)
class InterceptorTestActivity : AppCompatActivity(), View.OnClickListener {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_interceptor_test)

        //取参数
        val bundle = intent.extras
        if (bundle != null && !bundle.isEmpty) {
            var context = ""
            bundle.keySet().forEach {
                context += "${bundle[it]}\t"
            }
            btn_close.text = "拦截器测试页\n\n\n\n$context"
        }
    }

    override fun onClick(v: View) {
        this.finish()
    }
}
