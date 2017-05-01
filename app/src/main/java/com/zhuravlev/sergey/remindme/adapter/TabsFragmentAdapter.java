package com.zhuravlev.sergey.remindme.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.zhuravlev.sergey.remindme.fragment.AbstractTabFragment;
import com.zhuravlev.sergey.remindme.fragment.HomeFragment;
import com.zhuravlev.sergey.remindme.fragment.CategoriesFragment;

import java.util.HashMap;
import java.util.Map;

public class TabsFragmentAdapter extends FragmentPagerAdapter{

    private Map<Integer, AbstractTabFragment> tabs;
    private Context context; //Экземпляр MainActivity, наследника AppCompatActivity

    public TabsFragmentAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;
        initTabsMap(context);
    }

    @Override
    public Fragment getItem(int position) {
        return tabs.get(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabs.get(position).getTitle();
    }

    @Override
    public int getCount() {
        return tabs.size();
    }

    private void initTabsMap(Context context) {
        tabs = new HashMap<>();
        tabs.put(0, HomeFragment.getInstance(context));
        tabs.put(1, CategoriesFragment.getInstance(context));
    }
}
