package com.globant.android101.mvp.presenter;


import com.globant.android101.MapsActivity;
import com.globant.android101.R;
import com.globant.android101.mvp.model.MapsModel;
import com.globant.android101.mvp.view.MapsView;
import com.google.android.gms.maps.GoogleMap;

public class MapsPresenter {
    MapsModel model;
    MapsView view;


    public MapsPresenter(MapsModel model, MapsView view) {
        this.model = model;
        this.view = view;
    }

    public void onMapReady(GoogleMap map) {
        final MapsActivity activity = view.getActivity();
        if (activity == null) {
            return;
        }
        view.initMap(map);
        enableMyLocation();
    }


    public void enableMyLocation() {
        final MapsActivity activity = view.getActivity();
        if (activity == null) {
            return;
        }

        if (!model.checkSelfPermission(activity, android.Manifest.permission.ACCESS_FINE_LOCATION)) {
            // Permission to access the location is missing.
            view.requestPermission(activity, android.Manifest.permission.ACCESS_FINE_LOCATION, MapsActivity.LOCATION_PERMISSION_REQUEST_CODE);
            return;
        }

        view.enableMyLocation();
        view.showMessage(R.string.my_position);

    }

    public void onRequestPermissionsResult(int requestCode) {
        if (requestCode != MapsActivity.LOCATION_PERMISSION_REQUEST_CODE) {
            return;
        }
        final MapsActivity activity = view.getActivity();
        if (activity == null) {
            return;
        }

        if (model.checkSelfPermission(activity, android.Manifest.permission.ACCESS_FINE_LOCATION)) {
            enableMyLocation();
            return;
        }
        view.showMessage(R.string.permission_required_toast);
    }

}
