package com.hxd.arouterdemo

import android.app.Activity
import android.content.Context
import android.view.Gravity
import android.widget.Toast

/**
 * Create by yinzhengwei on 2019/1/14
 * @Function
 */
object ToastUtils {

    private var toast: Toast? = null

    fun showText(context: Context, text: String) {
        if (toast == null) {
            toast = Toast.makeText(context, text, Toast.LENGTH_SHORT).apply {
               // setGravity(Gravity.CENTER, 0, 0)
            }
        } else
            toast?.setText(text)
        toast?.show()
    }

}