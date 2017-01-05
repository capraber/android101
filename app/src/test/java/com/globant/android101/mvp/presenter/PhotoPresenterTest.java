package com.globant.android101.mvp.presenter;

import android.content.Intent;

import com.globant.android101.MainActivity;
import com.globant.android101.adapters.PhotoAdapter;
import com.globant.android101.model.Item;
import com.globant.android101.model.ItemList;
import com.globant.android101.mvp.events.GetItemsSuccessEvent;
import com.globant.android101.mvp.model.PhotoModel;
import com.globant.android101.mvp.view.PhotoView;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class PhotoPresenterTest {

    PhotoPresenter presenter;

    @Mock PhotoModel model;
    @Mock PhotoView view;
    @Mock MainActivity activity;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        Mockito.doNothing().when(model).getItemList();
        Mockito.when(view.getActivity()).thenReturn(activity);
        presenter = new PhotoPresenter(model, view);
    }

    @Test
    public void onItemsSuccessEvent() throws Exception {
        ItemList itemList = new ItemList();
        itemList.setImages(new Item[0]);
        GetItemsSuccessEvent event = new GetItemsSuccessEvent(itemList);
        presenter.onItemsSuccessEvent(event);

        Mockito.verify(view).setAdapter(Mockito.any(PhotoAdapter.class));
    }

    @Test
    public void showMapa() throws Exception {
        presenter.showMapa();
        Mockito.verify(view).getActivity();
        Mockito.verify(activity).startActivity(Mockito.any(Intent.class));
    }

}