package com.globant.android101.mvp.presenter;

import com.globant.android101.model.Item;
import com.globant.android101.mvp.events.GetItemEvent;
import com.globant.android101.mvp.model.ImageDialogModel;
import com.globant.android101.mvp.view.ImageDialogView;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class ImageDialogPresenterTest {

    ImageDialogPresenter presenter;

    @Mock ImageDialogModel model;
    @Mock ImageDialogView view;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        Mockito.doNothing().when(model).getItem(Mockito.anyInt());
        presenter = new ImageDialogPresenter(view, model);
    }

    @Test
    public void onItemsSuccessEvent() throws Exception {
        Item item = new Item();
        item.setId("1");
        item.setCopy_right("copyright 2017");
        item.setLarge_url("https://www.globant.com");
        item.setSite("globant");
        item.setUrl("www.globant.com");
        GetItemEvent event = new GetItemEvent(item);
        presenter.onItemsSuccessEvent(event);
        Mockito.verify(view).display(item.getLarge_url());
    }

}