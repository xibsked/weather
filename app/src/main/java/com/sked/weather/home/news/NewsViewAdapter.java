package com.sked.weather.home.news;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sked.weather.R;
import com.sked.weather.browse.WebViewActivity;
import com.sked.weather.data.Channel;
import com.sked.weather.util.UiUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.sked.weather.util.UiUtils.url;


/**
 * MachineLearning, All rights Reserved
 * Created by Sanjeet on 24-Nov-16.
 */

class NewsViewAdapter extends RecyclerView.Adapter {
    private final List<Channel.Item> rssItems;

    NewsViewAdapter(List<Channel.Item> rssItems) {
        this.rssItems = rssItems;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new NewsItemViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_news, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Channel.Item rssItem = rssItems.get(position);
        NewsItemViewHolder newsItemViewHolder = (NewsItemViewHolder) holder;
        newsItemViewHolder.title.setText(rssItem.getTitle());
        newsItemViewHolder.description.setText(UiUtils.localeDate(rssItem.getPubDate()));
        newsItemViewHolder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), WebViewActivity.class);
            intent.putExtra("url", rssItem.getLink());
            intent.putExtra("title", rssItem.getTitle());
            view.getContext().startActivity(intent);
        });
        Glide.with(holder.itemView.getContext())
                .load(url(rssItem.getDescription()))
                .error(R.drawable.ic_subject)
                .into(newsItemViewHolder.icon);
    }

    @Override
    public int getItemCount() {
        return rssItems.size();
    }

    class NewsItemViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.icon)
        ImageView icon;
        @BindView(R.id.name)
        TextView title;
        @BindView(R.id.description)
        TextView description;

        NewsItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
