package com.sked.weather;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.sked.weather.data.Error.Code;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Weather, All rights Reserved
 * Created by Sanjeet on 01-Jan-17.
 */

/**
 * Abstract base class for all fragments, which provide common
 * functionaries like binding the layout and unbinding it at
 * the destroy life cycle of the fragment
 */
public abstract class BaseFragment extends Fragment {
    private Unbinder unbinder;
    @Nullable
    @BindView(R.id.progress)
    ProgressBar progress;
    @Nullable
    @BindView(R.id.errorContainer)
    RelativeLayout errorView;

    /**
     * Binds the view using butter knife and holds the refrence
     * to Unbinder
     */
    public View bind(View view) {
        unbinder = ButterKnife.bind(this, view);
        if (errorView != null) errorView.setVisibility(View.GONE);
        return view;
    }

    public void progress(boolean toggle) {
        if (progress != null) progress.setVisibility(toggle ? View.VISIBLE : View.GONE);
    }

    public final void treat(String message) {
        if (errorView != null) {
            errorView.setVisibility(View.VISIBLE);
            ButterKnife.<TextView>findById(errorView, R.id.message).setText(message);
            ButterKnife.<Button>findById(errorView, R.id.retry).setOnClickListener(view -> {
                retry(Code.UNKNOWN_HOST);
                errorView.setVisibility(View.GONE);
            });
        }
    }

    public final void bake(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    public abstract void retry(Code code);

    /**
     * Unbinds the view using the undinder reference
     */
    @Override
    public void onDestroy() {
        unbinder.unbind();
        super.onDestroy();
    }
}
