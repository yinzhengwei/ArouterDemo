package com.hxd.arouterdemo

import android.content.Context
import android.net.Uri
import android.util.Log
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.facade.service.PathReplaceService

/**
 * Create by yinzhengwei on 2019/1/15
 * @Function 在没有或过滤掉拦截器的情况下实现跳转时路径重定向、保存跳转的历史数据等功能
 *
 * 这里的注解路径随便定义，只要不为空就行
 */
@Route(path = "/xxx/xxx")
class PathReplaceServiceImpl : PathReplaceService {

    override fun forString(path: String): String {
        //按照一定的规则处理之后返回处理后的结果
        // TODO
        return path
    }

    override fun forUri(uri: Uri): Uri {
        // 按照一定的规则处理之后返回处理后的结果
        return uri
    }

    override fun init(context: Context?) {
    }

}