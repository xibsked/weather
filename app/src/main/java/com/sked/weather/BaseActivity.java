package com.sked.weather;

import android.support.annotation.LayoutRes;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import butterknife.ButterKnife;

/**
 * Weather, All rights Reserved
 * Created by Sanjeet on 01-Jan-17.
 */

/**
 * An abstract base class for all activities , which serves some
 * common functionality like showing and hiding up indicator,
 * binding to the layouts as view using ButterKnife
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        //Bind this view with butter knife
        ButterKnife.bind(this);
    }

    /**
     * Enables up button on actionbar/toolbar
     */
    public void enableUpIndicator() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null)
            actionBar.setDisplayHomeAsUpEnabled(true);
    }

    public void setTitle(String title) {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null)
            actionBar.setTitle(title);
    }

    public void setSubtitle(String title) {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null)
            actionBar.setSubtitle(title);
    }

    /**
     * Handles back press of up home button, Finishes the activity which
     * has called the method enableUpIndicator method
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            onBackPressed();
        return super.onOptionsItemSelected(item);
    }
}
