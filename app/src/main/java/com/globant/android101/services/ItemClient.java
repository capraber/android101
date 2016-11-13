package com.globant.android101.services;

import com.globant.android101.model.Item;
import com.globant.android101.model.ItemList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ItemClient {
    @GET("/api/v1/images/latest")
    Call<ItemList> latestImages();

    @GET("/api/v1/images/{id}")
    Call<Item> image(@Path("id") int id);
}

