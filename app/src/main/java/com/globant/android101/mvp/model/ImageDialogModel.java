package com.globant.android101.mvp.model;

import com.globant.android101.services.ItemService;

public class ImageDialogModel {

    private int id;
    private ItemService service;

    public ImageDialogModel(ItemService service, int id) {
        this.service = service;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void getItem(int id) {
        service.getItem(id);
    }
}
