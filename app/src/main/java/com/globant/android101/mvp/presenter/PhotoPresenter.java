package com.globant.android101.mvp.presenter;

import android.content.Intent;

import com.globant.android101.MainActivity;
import com.globant.android101.MapsActivity;
import com.globant.android101.adapters.PhotoAdapter;
import com.globant.android101.mvp.events.GetItemsSuccessEvent;
import com.globant.android101.mvp.model.PhotoModel;
import com.globant.android101.mvp.view.PhotoView;
import com.squareup.otto.Subscribe;

public class PhotoPresenter {

    private PhotoModel model;
    private PhotoView view;

    public PhotoPresenter(PhotoModel model, PhotoView view) {

        this.model = model;
        this.view = view;
        init();
    }

    private void init() {
        model.getItemList();
    }

    @Subscribe
    public void onItemsSuccessEvent(GetItemsSuccessEvent event) {
        view.setAdapter(new PhotoAdapter(event.getItemList()));
    }

    public void showMapa() {
        final MainActivity activity = view.getActivity();
        if (activity == null) {
            return;
        }
        activity.startActivity(new Intent(activity, MapsActivity.class));
    }
}
