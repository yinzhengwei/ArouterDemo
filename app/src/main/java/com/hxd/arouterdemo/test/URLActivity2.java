package com.hxd.arouterdemo.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.hxd.arouterdemo.R;

import static com.hxd.arouterdemo.RouterPathUtilsKt.path2URLActivity2;


@Route(path = path2URLActivity2)
public class URLActivity2 extends AppCompatActivity implements View.OnClickListener {

    private TextView textView;

    @Autowired
    String name;

    @Autowired
    int age;

    @Autowired
    boolean boy;

    @Autowired
    int high;

    @Autowired
    String obj ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ARouter.getInstance().inject(this);
        setContentView(R.layout.activity_url2);

        textView = (TextView) findViewById(R.id.tv);

        //解析参数
        Bundle bundle = getIntent().getExtras();
        String name1 = bundle.getString("name");

        textView.setText("参数是： " + "name: " + name + "  age: " + age
                + " boy: " + boy + " name1: " + name1 + " obj: " + obj.toString() );
    }

    @Override
    public void onClick(View v) {
        this.finish();
    }
}
