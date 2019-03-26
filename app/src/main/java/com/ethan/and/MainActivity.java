package com.ethan.and;

import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.transition.Explode;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.common.componentes.TranslucentUtil;
import com.common.utils.activity.ActivityUtil;
import com.ethan.and.fragments.VideoListFragment;
import com.flybd.hvideo.R;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // 设置一个exit transition
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
            getWindow().setExitTransition(new Explode());
        }
        super.onCreate(savedInstanceState);
        TranslucentUtil.translucentWindow(this);
        setContentView(R.layout.activity_main);
        initialize();
    }

    private void initialize() {
        View content = findViewById(R.id.content);
        content.setPadding(content.getPaddingLeft(), content.getPaddingTop() + ActivityUtil.getStatusBarHeight(this), content.getPaddingRight(), content.getPaddingBottom());

        Toolbar toolbar = findViewById(R.id.tool_bar);
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, 0, 0);
        drawerToggle.syncState();
        drawerLayout.setDrawerListener(drawerToggle);

        mViewPager = findViewById(R.id.view_pager);

    }


    private class FragmentAdapter extends FragmentPagerAdapter {

        Fragment[] fragments = new Fragment[]{VideoListFragment.newInstance()};

        public FragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Log.i("FragmentAdapter", "getItem position $position id " + fragments[position].toString());
            return fragments[position];
        }

        @Override
        public int getCount() {
            return fragments.length;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            Object ret = super.instantiateItem(container, position);
            return ret;
        }
    }
}
