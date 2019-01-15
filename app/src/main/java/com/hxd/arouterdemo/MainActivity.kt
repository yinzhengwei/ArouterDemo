package com.hxd.arouterdemo

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.facade.callback.NavCallback
import com.alibaba.android.arouter.launcher.ARouter
import com.hxd.arouterdemo.MainActivity.getThis.activity
import com.yzw.javarouterdemo.module.ui.Contants
import com.yzw.javarouterdemo.module.ui.server.IService

@Route(path = path2MainActivity)
class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        activity = this
    }

    @SuppressLint("StaticFieldLeak")
    object getThis {
        var activity: Activity? = null
    }

    override fun onClick(v: View?) {
        when (v!!.tag.toString().toInt()) {
            0 -> ARouter.getInstance().build(path2TestActivity).navigation()
            1 -> {
                ARouter.getInstance().build(path2TestActivity)
                    .withString("name", "yzw")
                    .withInt("age", 10)
                    .withFloat("height", 180f)
                    .navigation()
            }
            2 -> ARouter.getInstance().build(path2TestActivity).navigation(this, object : NavCallback() {
                override fun onFound(postcard: Postcard?) {
                    ToastUtils.showText(this@MainActivity, "界面找到了,分组是${postcard?.group}")
                }

                override fun onLost(postcard: Postcard?) {
                    Log.d("ARouter", "找不到了")
                }

                override fun onArrival(postcard: Postcard) {
                    Log.d("ARouter", "跳转完了")
                }

                override fun onInterrupt(postcard: Postcard?) {
                    Log.d("ARouter", "被拦截了")
                }
            })
            //默认每个路径的第一级就是该路径的分组，这里可以动态指定和修改（目标界面里注解）
            3 -> ARouter.getInstance().build(path2TestActivity, "main").navigation(this, object : NavCallback() {
                override fun onArrival(postcard: Postcard) {
                    ToastUtils.showText(this@MainActivity, "跳转完了,分组是${postcard.group}")
                }
            })
            4 -> ARouter.getInstance().build(path2ForResultActivity).navigation(this, 1)
            5 -> ARouter.getInstance().build(path2WebActivity).navigation()
            6 -> ARouter.getInstance().build(path2InterceptorTestActivity).navigation()
            7 -> ARouter.getInstance().build(path2InterceptorTestActivity).greenChannel().navigation()
            8 -> {
                ARouter.getInstance().build(path2InterceptorTestActivity) .withOptionsCompat(
                        ActivityOptionsCompat.makeCustomAnimation(
                            this,
                            R.anim.slide_in_bottom, R.anim.slide_out_bottom
                        )
                    ).navigation()
            }
            9 -> ARouter.getInstance().build(path2InterceptorTestActivity).greenChannel()
                .withFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                .navigation()
            10 -> {
                ARouter.getInstance().build(Contants.path2ModuleActivity).navigation(this, object : NavCallback() {
                    override fun onArrival(postcard: Postcard?) {
                        this@MainActivity.finish()
                    }
                })
            }
            11 -> {
                val myService = ARouter.getInstance().build(Contants.path2Sercive).navigation() as IService
                myService.sayHello(this)
            }
            12 -> {
                ARouter.getInstance().build("/hxd/xxx").navigation()
            }
            100 -> {
                //获取Fragment 实例
                val fragment = ARouter.getInstance().build(path2TestFragment).navigation() as Fragment

                //添加Fragment
                supportFragmentManager.beginTransaction().run {
                    add(R.id.fragmentLayout, fragment)
                    commit()
                }
            }
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1) {
            ToastUtils.showText(this, "forResult")
        }
    }

}
