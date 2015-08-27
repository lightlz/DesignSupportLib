package com.light.designsupportdemo;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.light.designsupportdemo.ui.fragment.FabOneFragment;
import com.light.designsupportdemo.ui.fragment.FabSecondFragment;
import com.light.designsupportdemo.ui.fragment.FabThreeFragment;
import com.light.designsupportdemo.ui.fragment.FirstFragment;
import com.light.designsupportdemo.ui.fragment.SecordFragment;
import com.light.designsupportdemo.ui.fragment.ThirdFragment;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawer;
    private Toolbar toolbar;

    private NavigationView mNavigationView;

    private ActionBarDrawerToggle drawerToggle;

    private AppBarLayout appBarLayout;

    private ActionBar ab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerToggle = setupDrawerToggle();
        mDrawer.setDrawerListener(drawerToggle);

        // 使用导航按钮
        ab = getSupportActionBar();
        //ab.setHomeAsUpIndicator(R.drawable.ic_menu);
        ab.setDisplayHomeAsUpEnabled(true);


        // 点击导航栏选项，切换 fragment
        mNavigationView = (NavigationView)findViewById(R.id.navigation_view);
        setDrawerContent(mNavigationView);

        appBarLayout = (AppBarLayout)findViewById(R.id.appbar);


    }

    private ActionBarDrawerToggle setupDrawerToggle() {
        return new ActionBarDrawerToggle(this, mDrawer, toolbar, R.string.drawer_open,  R.string.drawer_close);
    }

    // 设置 drawer 内容
    private void setDrawerContent(NavigationView view){

        view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                changeFragmentContent(menuItem);
                return true;
            }
        });
    }

    // 更改 fragment 内容
    private void changeFragmentContent(MenuItem menuItem){

        Fragment fragment = null;
        Class fragmentClass = null;

        switch (menuItem.getItemId()){
            case R.id.nav_first:
                fragmentClass = FirstFragment.class;
                break;

            case R.id.nav_second:
                fragmentClass = SecordFragment.class;
                break;

            case R.id.nav_third:
                fragmentClass = ThirdFragment.class;
                break;

            case R.id.nav_fab1:
                fragmentClass = FabOneFragment.class;
                break;
            case R.id.nav_fab2:
                fragmentClass = FabSecondFragment.class;
                break;
            case R.id.nav_fab3:
                fragmentClass = FabThreeFragment.class;
                break;

        }

        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();

        // 选中高亮
        menuItem.setChecked(true);
        setTitle(menuItem.getTitle());
        mDrawer.closeDrawers();

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id) {
            case android.R.id.home:
                mDrawer.openDrawer(GravityCompat.START);

                return true;
        }

        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
