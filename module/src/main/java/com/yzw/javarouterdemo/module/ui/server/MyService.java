package com.yzw.javarouterdemo.module.ui.server;

import android.content.Context;
import android.widget.Toast;
import com.alibaba.android.arouter.facade.annotation.Route;

import static com.yzw.javarouterdemo.module.ui.Contants.path2Sercive;

/**
 * Create by yinzhengwei on 2019/1/15
 *
 * @Function 方便module里调用其他组件模块或者app里的方法
 * <p>
 * 方法和处理类共享
 */

@Route(path = path2Sercive, name = "测试服务")
public class MyService implements IService {

    @Override
    public void sayHello(Context context) {
        Toast.makeText(context, "hello", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void init(Context context) {

    }
}
