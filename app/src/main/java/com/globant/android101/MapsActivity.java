package com.globant.android101;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;

import com.globant.android101.mvp.model.MapsModel;
import com.globant.android101.mvp.presenter.MapsPresenter;
import com.globant.android101.mvp.view.MapsView;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

public class MapsActivity extends AppCompatActivity implements
        GoogleMap.OnMyLocationButtonClickListener,
        OnMapReadyCallback,
        ActivityCompat.OnRequestPermissionsResultCallback {


    public static final int LOCATION_PERMISSION_REQUEST_CODE = 1;
    MapsPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        SupportMapFragment mapFragment =
                (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        presenter = new MapsPresenter(new MapsModel(), new MapsView(this));
    }

    @Override
    public void onMapReady(GoogleMap map) {
        presenter.onMapReady(map);
    }


    @Override
    public boolean onMyLocationButtonClick() {
        presenter.enableMyLocation();
        return false;
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        presenter.onRequestPermissionsResult(requestCode);

    }
}
