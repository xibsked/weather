package com.sked.weather.home;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.sked.weather.BaseActivity;
import com.sked.weather.R;
import com.sked.weather.data.remote.Repository;
import com.sked.weather.home.daily.DailyFragment;
import com.sked.weather.home.news.NewsFragment;
import com.sked.weather.home.overview.OverviewFragment;
import com.sked.weather.view.WaveHelper;
import com.sked.weather.view.WaveView;

import butterknife.BindView;

public class HomeActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.pager)
    ViewPager pager;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.waveView)
    WaveView waveView;
    private WaveHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setSupportActionBar(toolbar);
        pager.setAdapter(new PagerAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(pager);
        updateHeader();
        waveView.setShapeType(WaveView.ShapeType.SQUARE);
        waveView.setWaveColor(ContextCompat.getColor(this, R.color.colorWavePrimary),
                ContextCompat.getColor(this, R.color.colorWaveDark));
        helper = new WaveHelper(waveView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        helper.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        helper.cancel();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void updateHeader() {
        Repository.getInstance().getPlaceInfo(placeInfo -> {
            setSubtitle(placeInfo.name());
            setTitle(getString(R.string.label_temperature, placeInfo.parameters().temperature() - 273.15));
        });
    }

    class PagerAdapter extends FragmentPagerAdapter {

        PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 1:
                    return DailyFragment.newInstance();
                case 2:
                    return NewsFragment.newInstance();
            }
            return OverviewFragment.newInstance();
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return getString(R.string.label_overview);
                case 1:
                    return getString(R.string.label_daily);
                case 2:
                    return getString(R.string.label_news);
            }
            return super.getPageTitle(position);
        }
    }
}
