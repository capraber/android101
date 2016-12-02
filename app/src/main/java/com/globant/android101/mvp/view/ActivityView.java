package com.globant.android101.mvp.view;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.Nullable;

import java.lang.ref.WeakReference;

public class ActivityView<T> {
    private WeakReference<T> activityRef;
    private ProgressDialog progressDialog;

    public ActivityView(T activity) {
        activityRef = new WeakReference<>(activity);
    }

    @Nullable
    public T getActivity() {
        return activityRef.get();
    }

    @Nullable
    public Context getContext() {
        return (Context) getActivity();
    }

    public Resources getResources() {
        return getContext().getResources();
    }
}

