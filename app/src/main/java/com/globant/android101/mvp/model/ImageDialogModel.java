package com.globant.android101.mvp.model;

import com.globant.android101.model.Item;
import com.globant.android101.mvp.events.GetItemEvent;
import com.globant.android101.services.ItemClient;
import com.globant.android101.services.ServiceGenerator;
import com.squareup.otto.Bus;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ImageDialogModel {

    private Bus bus;

    public ImageDialogModel(Bus bus) {
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
}
