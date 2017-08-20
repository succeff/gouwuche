package com.bwie.gouwuche;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import adapter.FragAdapter;


public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager vp;
    private String[] name = {"月光茶人", "优惠", "购物车", "我的"};
    private List<String> list_tab = new ArrayList<>();
    private List<Fragment> list_frag = new ArrayList<>();
    private FragAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabView();
    }

    private void tabView() {
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        vp = (ViewPager) findViewById(R.id.view_pager);
        for (String bean : name) {
            list_tab.add(bean);
        }
        for (int i = 0; i < name.length; i++) {
            tabLayout.addTab(tabLayout.newTab().setText(list_tab.get(i)));
        }
        YueFragment yueFragment = new YueFragment();
        YouFragment youFragment = new YouFragment();
        GouFragment gouFragment = new GouFragment();
        MineFragment mineFragment = new MineFragment();

        list_frag.add(yueFragment);
        list_frag.add(youFragment);
        list_frag.add(gouFragment);
        list_frag.add(mineFragment);
        adapter = new FragAdapter(this.getSupportFragmentManager(), list_frag, list_tab);
        vp.setAdapter(adapter);
        tabLayout.setupWithViewPager(vp);

        tabLayout.getTabAt(0).setText(list_tab.get(0)).setIcon(R.drawable.yue);
        tabLayout.getTabAt(1).setText(list_tab.get(1)).setIcon(R.drawable.you);
        tabLayout.getTabAt(2).setText(list_tab.get(2)).setIcon(R.drawable.gou);
        tabLayout.getTabAt(3).setText(list_tab.get(3)).setIcon(R.drawable.me);

    }
}
