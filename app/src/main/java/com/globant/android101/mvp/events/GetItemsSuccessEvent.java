package com.globant.android101.mvp.events;

import com.globant.android101.model.Item;
import com.globant.android101.model.ItemList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetItemsSuccessEvent {
    ItemList itemList;

    public GetItemsSuccessEvent(ItemList itemList) {
        this.itemList = itemList;
    }

    public List<Item> getItemList() {
        return new ArrayList<>(Arrays.asList(itemList.getImages()));
    }
}
