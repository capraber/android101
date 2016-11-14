package com.globant.android101.mvp.model;

import com.globant.android101.model.ItemList;
import com.globant.android101.mvp.events.GetItemsSuccessEvent;
import com.globant.android101.services.ItemClient;
import com.globant.android101.services.ServiceGenerator;
import com.squareup.otto.Bus;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhotoModel {

    private Bus bus;

    public PhotoModel(Bus bus) {
        this.bus = bus;
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
