package com.globant.android101.mvp.view;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.lang.ref.WeakReference;

public class ActivityView {
    private WeakReference<AppCompatActivity> activityRef;
    private ProgressDialog progressDialog;

    public ActivityView(AppCompatActivity activity) {
        activityRef = new WeakReference<>(activity);
    }

    @Nullable
    public AppCompatActivity getActivity() {
        return activityRef.get();
    }

    @Nullable
    public Context getContext() {
        return getActivity();
    }

    public Resources getResources() {
        return getActivity().getResources();
    }
}

