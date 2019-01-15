package com.yzw.javarouterdemo.module.ui

import android.app.Activity
import android.os.Bundle
import android.view.View
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.facade.callback.NavCallback
import com.alibaba.android.arouter.launcher.ARouter
import com.yzw.javarouterdemo.module.R
import com.yzw.javarouterdemo.module.ui.Contants.path2ModuleActivity

/**
 * Create by yinzhengwei on 2019/1/15
 * @Function
 */
@Route(path = path2ModuleActivity)
class ModuleActivity : Activity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module)
    }

    override fun onClick(v: View?) {
        ARouter.getInstance().build("/hxd/main").navigation(this, object : NavCallback() {
            override fun onArrival(postcard: Postcard?) {
                this@ModuleActivity.finish()
            }
        })
    }
}