package com.globant.android101.mvp.presenter;

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
    }

    @Subscribe
    public void onLoginSuccessEvent(GetItemsSuccessEvent event) {
        view.setAdapter(new PhotoAdapter(event.getItemList()));
    }
}
