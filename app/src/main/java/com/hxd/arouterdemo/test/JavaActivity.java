package com.hxd.arouterdemo.test;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.hxd.arouterdemo.R;

import static com.hxd.arouterdemo.RouterPathUtilsKt.path2JavaActivity;
import static com.hxd.arouterdemo.RouterPathUtilsKt.path2MainActivity;

/**
 * Create by yinzhengwei on 2019/1/11
 *
 * @Function
 */

@Route(path = path2JavaActivity)
public class JavaActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java);

        findViewById(R.id.tv_java).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build(path2MainActivity).navigation();
                JavaActivity.this.finish();
            }
        });

    }
}
