package com.globant.android101.mvp.model;

import com.globant.android101.services.ItemService;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class PhotoModelTest {
    PhotoModel model;
    @Mock ItemService service;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        model = new PhotoModel(service);
    }

    @Test
    public void getItemList() throws Exception {
        model.getItemList();
        Mockito.verify(service).getItemList();

    }

}