package com.globant.android101.mvp.model;

import com.globant.android101.services.ItemService;

public class PhotoModel {

    private ItemService service;

    public PhotoModel(ItemService service) {
        this.service = service;
    }

    public void getItemList() {
        service.getItemList();
    }
}
