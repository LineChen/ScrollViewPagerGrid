package com.example.administrator.scrollviewpagergrid;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    List<View> pages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initPages();

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new MyPageAdapter());
    }


    private void initPages() {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.item_listview,
                new String[]{"asdf", "ASD", "jdjlk", "sdfiou", "65asd", "asdf", "ASD", "jdjlk", "sdfiou", "65asd"});
        pages = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            View view = LayoutInflater.from(this).inflate(R.layout.item_page, null);
            GridView grid = (GridView) view.findViewById(R.id.gridview);
            grid.setAdapter(adapter);
            pages.add(view);
        }
    }


    // 自定义显示页面的适配器
    class MyPageAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return pages.size();
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(pages.get(position));
            return pages.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(pages.get(position));
        }

        @Override
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

}
