package com.hxd.arouterdemo.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.hxd.arouterdemo.R;

import static com.hxd.arouterdemo.RouterPathUtilsKt.path2URLActivity1;

/**
 * URL Activity
 */

@Route(path = path2URLActivity1)
public class URLActivity1 extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_url1);
    }

    @Override
    public void onClick(View v) {
        this.finish();
    }
}
