package com.globant.android101.adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.globant.android101.ImageDialog;
import com.globant.android101.R;
import com.globant.android101.model.Item;
import com.globant.android101.utils.ImageLoadedCallback;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder>{

    private List<Item> items;

    public PhotoAdapter(List<Item> items) {
        this.items = items;
    }

    @Override
    public PhotoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cards_layout, parent, false);
        return new PhotoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final PhotoViewHolder viewHolder, int position) {
        final Item imageInfo = items.get(position);

        viewHolder.id.setText(String.valueOf(imageInfo.getId()));
        viewHolder.urlText.setText(imageInfo.getUrl());
        Picasso.with(viewHolder.image.getContext()).
                load(imageInfo.getUrl()).resize(200, 200)
                .into(viewHolder.image,  new ImageLoadedCallback(viewHolder.progressBar) {
                    @Override
                    public void onSuccess() {
                        if (viewHolder.progressBar != null) {
                            viewHolder.progressBar.setVisibility(View.GONE);
                        }
                    }
                });
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return items != null ? items.size() : 0;
    }

    public static class PhotoViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.image_thumbnail) ImageView image;
        @BindView(R.id.image_url) TextView urlText;
        @BindView(R.id.image_id) TextView id;
        @BindView(R.id.progressBar) ProgressBar progressBar;
        Activity activity;

        public PhotoViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            activity = (Activity) itemView.getContext();
        }

        @OnClick(R.id.image_thumbnail)
        public void onImageClick() {
            new ImageDialog(activity, Integer.parseInt(id.getText().toString())).show();
        }
    }
}