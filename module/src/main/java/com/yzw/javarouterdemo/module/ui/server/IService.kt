package com.yzw.javarouterdemo.module.ui.server

import android.content.Context
import com.alibaba.android.arouter.facade.template.IProvider

/**
 * Create by yinzhengwei on 2019/1/15
 * @Function 方便module里调用其他组件模块或者app里的方法
 *
 * 方法和处理类共享
 */
interface IService : IProvider {

    fun sayHello(context: Context)

}