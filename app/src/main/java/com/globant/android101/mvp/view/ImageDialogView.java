package com.globant.android101.mvp.view;

import android.app.Dialog;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.globant.android101.R;
import com.globant.android101.utils.ImageLoadedCallback;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ImageDialogView extends DialogView {

    @BindView(R.id.dialog_image) ImageView image;
    @BindView(R.id.progressBar) ProgressBar progressBar;

    public ImageDialogView(Dialog dialog) {
        super(dialog);
        ButterKnife.bind(this, dialog);
    }

    public void display(String imageUrl) {
        Picasso.with(image.getContext()).
                load(imageUrl)
                .into(image,  new ImageLoadedCallback(progressBar) {
                    @Override
                    public void onSuccess() {
                        if (progressBar != null) {
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });
    }

}