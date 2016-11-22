package com.globant.android101.services;


import com.globant.android101.model.Item;
import com.globant.android101.model.ItemList;
import com.globant.android101.mvp.events.GetItemEvent;
import com.globant.android101.mvp.events.GetItemsSuccessEvent;
import com.squareup.otto.Bus;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ItemService {
    private Bus bus;

    public ItemService(Bus bus) {
        this.bus = bus;
    }

    public void getItem(int id) {
        ItemClient client = ServiceGenerator.createService(ItemClient.class);

        Call<Item> call =
                client.image(id);

        call.enqueue(new Callback<Item>() {
            @Override
            public void onResponse(Call<Item> call, Response<Item> response) {
                bus.post(new GetItemEvent(response.body()));
            }

            @Override
            public void onFailure(Call<Item> call, Throwable t) {
                //Handle failure
            }
        });
    }

    public void getItemList() {
        ItemClient client = ServiceGenerator.createService(ItemClient.class);

        Call<ItemList> call =
                client.latestImages();

        call.enqueue(new Callback<ItemList>() {
            @Override
            public void onResponse(Call<ItemList> call, Response<ItemList> response) {
                bus.post(new GetItemsSuccessEvent(response.body()));
            }

            @Override
            public void onFailure(Call<ItemList> call, Throwable t) {
                //Handle failure
            }
        });
    }


}
