package com.hxd.arouterdemo.test;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.hxd.arouterdemo.R;

import static com.hxd.arouterdemo.RouterPathUtilsKt.path2TestFragment;

@Route(path = path2TestFragment)
public class TestFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_test, container, false);
        return view ;
    }
}
