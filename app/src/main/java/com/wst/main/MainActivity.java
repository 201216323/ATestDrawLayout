package com.wst.main;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.lhh.apst.library.AdvancedPagerSlidingTabStrip;
import com.wst.R;
import com.wst.widget.NoMoveViewPager;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    Toolbar toolbar;
    DrawerLayout drawer;
    NavigationView navigationView;
    FloatingActionButton floatingActionButton;
    @BindView(R.id.tabs)
    AdvancedPagerSlidingTabStrip tabs;
    @BindView(R.id.vp_main)
    NoMoveViewPager vp_main;
    @BindView(R.id.ivCenterBtn)
    ImageView ivCenterBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        floatingActionButton = (FloatingActionButton) findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "aaaa", Snackbar.LENGTH_LONG)
                        .show();
            }
        });
        init();
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {
            Toast.makeText(MainActivity.this, "nav_gallery", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void init() {
        //自己的代码
        ivCenterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "ivCenterBtn", Toast.LENGTH_SHORT).show();
            }
        });

        int mSize = getResources().getDimensionPixelSize(R.dimen.weibo_tab_size);
        vp_main.setOffscreenPageLimit(MainFragmentAdapter.VIEW_SIZE);
        FragmentManager fragmentManager = getSupportFragmentManager();
        MainFragmentAdapter adapter = new MainFragmentAdapter(this, fragmentManager, mSize);
        vp_main.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        tabs.setViewPager(vp_main);
//        tabs.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
////                Toast.makeText(MainActivity.this, "position:" + position, Toast.LENGTH_SHORT).show();
//                Snackbar.make(tabs, "position:"+position, Snackbar.LENGTH_LONG)
//                        .show();
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });
        vp_main.setCurrentItem(MainFragmentAdapter.VIEW_FIRST);
        tabs.showDot(MainFragmentAdapter.VIEW_FIRST, "0");
    }

}
