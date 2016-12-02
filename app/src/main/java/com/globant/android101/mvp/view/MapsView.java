package com.globant.android101.mvp.view;


import android.support.annotation.StringRes;
import android.support.v4.app.ActivityCompat;
import android.widget.Toast;

import com.globant.android101.MapsActivity;
import com.globant.android101.R;
import com.google.android.gms.maps.GoogleMap;

public class MapsView extends ActivityView<MapsActivity> {

    private GoogleMap map;

    public MapsView(MapsActivity activity) {
        super(activity);
    }

    public void initMap(GoogleMap map) {
        final MapsActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        this.map = map;
        this.map.setOnMyLocationButtonClickListener(activity);

    }

    public void enableMyLocation() throws SecurityException {
        if (map != null) {
            map.setMyLocationEnabled(true);
        }

    }

    public void requestPermission(MapsActivity activity, String permission, int requestCode) {
        ActivityCompat.requestPermissions(activity, new String[]{permission}, requestCode);

    }

    public void showMessage(@StringRes int message) {
        final MapsActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show();
    }

}
