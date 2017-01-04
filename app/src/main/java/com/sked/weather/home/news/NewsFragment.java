package com.sked.weather.home.news;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sked.weather.BaseFragment;
import com.sked.weather.R;
import com.sked.weather.data.Channel;
import com.sked.weather.data.Error;
import com.sked.weather.data.Error.Code;
import com.sked.weather.data.remote.DataSource;
import com.sked.weather.data.remote.Repository;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends BaseFragment implements DataSource.NewsCallback {
    @BindView(R.id.newsView)
    RecyclerView newsView;
    private List<Channel.Item> news;
    private NewsViewAdapter adapter;

    public NewsFragment() {
    }

    public static NewsFragment newInstance() {
        Bundle args = new Bundle();
        NewsFragment fragment = new NewsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        news = new ArrayList<>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        adapter = new NewsViewAdapter(news);
        return bind(inflater.inflate(R.layout.fragment_news, container, false));
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        newsView.setLayoutManager(new LinearLayoutManager(getActivity()));
        newsView.setAdapter(adapter);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        progress(true);
        Repository.getInstance().news(this);
    }

    @Override
    public void onNewsFetched(List<Channel.Item> rssItems) {
        progress(false);
        news.clear();
        news.addAll(rssItems);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onError(Error error) {
        progress(false);
        treat(error.message());
    }

    @Override
    public void retry(Code code) {
        progress(true);
        Repository.getInstance().news(this);
    }
}
