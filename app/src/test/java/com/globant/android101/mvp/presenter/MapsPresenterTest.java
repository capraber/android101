package com.globant.android101.mvp.presenter;

import com.globant.android101.MapsActivity;
import com.globant.android101.R;
import com.globant.android101.mvp.model.MapsModel;
import com.globant.android101.mvp.view.MapsView;
import com.google.android.gms.maps.GoogleMap;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class MapsPresenterTest {

    MapsPresenter presenter;

    @Mock MapsModel model;
    @Mock MapsView view;
    @Mock MapsActivity activity;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        Mockito.when(view.getActivity()).thenReturn(activity);
        presenter = new MapsPresenter(model, view);
    }

    @Test
    public void onMapReady() throws Exception {
        Mockito.when(model.checkSelfPermission(activity, android.Manifest.permission.ACCESS_FINE_LOCATION)).thenReturn(true);

        GoogleMap map = null;
        presenter.onMapReady(map);
        Mockito.verify(view).initMap(map);
        Mockito.verify(view, Mockito.times(2)).getActivity();
        Mockito.verify(model).checkSelfPermission(activity, android.Manifest.permission.ACCESS_FINE_LOCATION);
        Mockito.verify(view).enableMyLocation();
        Mockito.verify(view).showMessage(R.string.my_position);


    }

    @Test
    public void enableMyLocation() throws Exception {
        Mockito.when(model.checkSelfPermission(activity, android.Manifest.permission.ACCESS_FINE_LOCATION)).thenReturn(false);
        presenter.enableMyLocation();
        Mockito.verify(view).getActivity();
        Mockito.verify(model).checkSelfPermission(activity, android.Manifest.permission.ACCESS_FINE_LOCATION);
        Mockito.verify(view).requestPermission(activity, android.Manifest.permission.ACCESS_FINE_LOCATION, MapsActivity.LOCATION_PERMISSION_REQUEST_CODE);

    }

    @Test
    public void onRequestPermissionsResult() throws Exception {
        Mockito.when(model.checkSelfPermission(activity, android.Manifest.permission.ACCESS_FINE_LOCATION)).thenReturn(false);

        presenter.onRequestPermissionsResult(MapsActivity.LOCATION_PERMISSION_REQUEST_CODE);
        Mockito.verify(view).getActivity();
        Mockito.verify(model).checkSelfPermission(activity, android.Manifest.permission.ACCESS_FINE_LOCATION);
        Mockito.verify(view).showMessage(R.string.permission_required_toast);
    }

}