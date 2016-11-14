package com.globant.android101.mvp.events;

import com.globant.android101.model.Item;

public class GetItemEvent {
    Item item;

    public GetItemEvent(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return item;
    }
}
