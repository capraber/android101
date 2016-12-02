package com.globant.android101.mvp.model;


import android.content.pm.PackageManager;
import android.support.v4.content.ContextCompat;

import com.globant.android101.MapsActivity;

public class MapsModel {

    public boolean checkSelfPermission(MapsActivity activity, String permission) {
        return (ContextCompat.checkSelfPermission(activity, permission) == PackageManager.PERMISSION_GRANTED);
    }
}
