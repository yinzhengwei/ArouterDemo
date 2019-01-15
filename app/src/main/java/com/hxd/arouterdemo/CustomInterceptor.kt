package com.hxd.arouterdemo

import android.app.AlertDialog
import android.content.Context
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log
import android.widget.Toast
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.annotation.Interceptor
import com.alibaba.android.arouter.facade.callback.InterceptorCallback
import com.alibaba.android.arouter.facade.template.IInterceptor

/**
 * Create by yinzhengwei on 2019/1/14
 * @Function 自定义拦截器
 *
 * 比较经典的应用就是在跳转过程中处理登陆事件，这样就不需要在目标页重复做登陆检查
 * 其次是在获取或构造某个对象时，可以统一对属性值进行修改
 *
 * 拦截器会在跳转之间执行，多个拦截器会按优先级顺序依次执行(值越小级别越高)
 *
 * 拦截器是在线程里执行的，为了逻辑的处理不阻塞主线程
 */

@Interceptor(priority = 1, name = "登陆测试用拦截器")
class CustomLoginInterceptor : IInterceptor {

    var mContext: Context? = null

    override fun process(postcard: Postcard?, callback: InterceptorCallback?) {

        Log.d("CustomInterceptor", "login")

        //只对指定的界面做处理,这里也可以判断分组
        if (postcard?.path == path2InterceptorTestActivity) {
            try {
                val text = "拦截到了InterceptorTestActivity的跳转\n优先级别是：${postcard.priority}\n已登陆"

                MainActivity.getThis.activity?.runOnUiThread {
                    ToastUtils.showText(MainActivity.getThis.activity!!, text)
                }
                // 处理完成，交还控制权
                callback?.onContinue(postcard)
            } catch (e: Exception) {
                e.toString()
                // 觉得有问题，中断路由流程
                callback?.onInterrupt(RuntimeException("我觉得有点异常"));
            }
        } else
            callback?.onContinue(postcard)
    }

    override fun init(context: Context?) {
        // 拦截器的初始化，会在sdk初始化的时候调用该方法，仅会调用一次
        mContext = context
    }

}

@Interceptor(priority = 2, name = "网络监听测试用拦截器")
class CustomNetStateInterceptor : IInterceptor {

    var mContext: Context? = null

    override fun process(postcard: Postcard?, callback: InterceptorCallback?) {

        Log.d("CustomInterceptor", "netState")

        //只对指定的界面做处理,这里也可以判断分组
        if (postcard?.path == path2InterceptorTestActivity) {
            val text = "拦截到了InterceptorTestActivity的跳转\n优先级别是：${postcard.priority}\n网络可用"
            MainActivity.getThis.activity?.runOnUiThread {
                Toast.makeText(MainActivity.getThis.activity, text, Toast.LENGTH_SHORT).show()
            }
            callback?.onContinue(postcard)
        } else
            callback?.onContinue(postcard)
    }

    override fun init(context: Context?) {
        // 拦截器的初始化，会在sdk初始化的时候调用该方法，仅会调用一次
        mContext = context
    }

}

@Interceptor(priority = 3, name = "单个界面及参数添加测试用拦截器")
class CustomUiParamsInterceptor : IInterceptor {

    var mContext: Context? = null

    override fun process(postcard: Postcard?, callback: InterceptorCallback?) {

        Log.d("CustomInterceptor", "params")

        //只对指定的界面做处理,这里也可以判断分组
        if (path2InterceptorTestActivity == postcard?.path) {
            val ab = AlertDialog.Builder(MainActivity.getThis.activity)
            ab.setCancelable(false)
            ab.setTitle("温馨提醒")
            ab.setMessage("想要跳转到InterceptorTestActivity么？(触发了${postcard.path}拦截器，拦截了本次跳转)")
            ab.setNegativeButton("继续") { _, _ ->
                callback?.onContinue(postcard)
            }
            ab.setNeutralButton("算了") { _, _ ->
                callback?.onInterrupt(null)
            }
            ab.setPositiveButton("加点料") { _, _ ->
                postcard.withString("extra", "我是在拦截器中附加的参数")
                callback?.onContinue(postcard)
            }

            object : Handler(Looper.getMainLooper()) {
                override fun handleMessage(msg: Message) {
                    super.handleMessage(msg)
                    ab.create().show()
                }
            }.sendEmptyMessage(0)
        } else {
            callback?.onContinue(postcard)
        }
    }

    override fun init(context: Context?) {
        // 拦截器的初始化，会在sdk初始化的时候调用该方法，仅会调用一次
        mContext = context
    }

}