package com.globant.android101.mvp.presenter;

import com.globant.android101.mvp.events.GetItemEvent;
import com.globant.android101.mvp.model.ImageDialogModel;
import com.globant.android101.mvp.view.ImageDialogView;
import com.squareup.otto.Subscribe;

public class ImageDialogPresenter {
    private ImageDialogView view;
    private ImageDialogModel model;

    public ImageDialogPresenter(ImageDialogView view, ImageDialogModel model) {
        this.view = view;
        this.model = model;
        init();
    }

    private void init() {
        model.getItem(model.getId());
    }

    @Subscribe
    public void onItemsSuccessEvent(GetItemEvent event) {
        view.display(event.getItem().getLarge_url());
    }

}
