package com.globant.android101.mvp.view;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.Nullable;

import java.lang.ref.WeakReference;

public class DialogView {
    private WeakReference<Dialog> dialogRef;

    public DialogView(Dialog dialog) {
        dialogRef = new WeakReference<>(dialog);
    }

    @Nullable
    public Dialog getDialog() {
        return dialogRef.get();
    }

    @Nullable
    public Context getContext() {
        return dialogRef.get().getContext();
    }
}
