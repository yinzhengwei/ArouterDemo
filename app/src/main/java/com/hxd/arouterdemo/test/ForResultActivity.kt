package com.hxd.arouterdemo.test

import android.app.Activity
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.hxd.arouterdemo.*
import kotlinx.android.synthetic.main.activity_forresult.*
import kotlinx.android.synthetic.main.activity_test.*

/**
 * Create by yinzhengwei on 2019/1/10
 * @Function
 */
@Route(path = path2ForResultActivity)
class ForResultActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forresult)

        tv_forresult.setOnClickListener {
            this@ForResultActivity.finish()
        }
    }

}