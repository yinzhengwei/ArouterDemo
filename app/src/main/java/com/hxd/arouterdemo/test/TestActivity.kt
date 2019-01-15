package com.hxd.arouterdemo.test

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.hxd.arouterdemo.R
import com.hxd.arouterdemo.path2JavaActivity
import com.hxd.arouterdemo.path2TestActivity
import kotlinx.android.synthetic.main.activity_test.*

/**
 * Create by yinzhengwei on 2019/1/10
 * @Function
 *
 * Route 里有多个参数，我们经常需要在目标页面中配置一些属性，比方说"是否需要登陆"之类的
 *
 * 可以通过 Route 注解中的 extras 属性进行扩展，这个属性是一个 int值，换句话说，单个int有4字节，也就是32位，可以配置32个开关
 * 剩下的可以自行发挥，通过字节操作可以标识32个开关，
 *
 * 通过开关标记目标页面的一些属性，在拦截器中可以拿到这个标记进行业务逻辑判断
 *
 */

@Route(path = path2TestActivity)
class TestActivity : Activity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        //取参数
        val bundle = intent.extras
        if (bundle != null && !bundle.isEmpty) {
            var context = ""
            bundle.keySet().forEach {
                context += "$it:${bundle[it]}\n"
            }
            tv_java.text = "${tv_java.text}\n$context"
        }

        tv_java.setOnClickListener {
            ARouter.getInstance().build(path2JavaActivity).navigation()
            this@TestActivity.finish()
        }
    }

}