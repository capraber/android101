package com.globant.android101.mvp.model;

import com.globant.android101.services.ItemService;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class ImageDialogModelTest {

    ImageDialogModel model;
    @Mock ItemService service;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        model = new ImageDialogModel(service, 1);
    }

    @Test
    public void getItem() throws Exception {
        model.getItem(1);
        Mockito.verify(service).getItem(1);
    }

}