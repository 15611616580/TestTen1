package com.bwie.testten;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.hjm.bottomtabbar.BottomTabBar;

import cart.view.Cartfragment;
import homepage.view.Homefragment;
import mine.view.Minefragment;
import sort.view.Sortfragment;

public class MainActivity extends AppCompatActivity {
    private BottomTabBar bottomTabBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        initView();

    }

    private void initView() {
        bottomTabBar = (BottomTabBar) findViewById(R.id.bottomTabBar);
        //底部导航栏
        bottomTabBar.init(getSupportFragmentManager())
                .setImgSize(35, 35)
                .setFontSize(10)
                .setChangeColor(Color.RED, Color.GRAY)
                .addTabItem("首页", R.mipmap.zy1, R.mipmap.zy2, Homefragment.class)
                .addTabItem("分类", R.mipmap.fl, R.mipmap.fl2, Sortfragment.class)
                .addTabItem("购物车", R.mipmap.gwc, R.mipmap.gwc2, Cartfragment.class)
                .addTabItem("个人", R.mipmap.gr, R.mipmap.gr2, Minefragment.class)
                .isShowDivider(false);

    }
}
