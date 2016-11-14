package com.globant.android101;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;

import com.globant.android101.mvp.model.ImageDialogModel;
import com.globant.android101.mvp.presenter.ImageDialogPresenter;
import com.globant.android101.mvp.view.ImageDialogView;
import com.globant.android101.utils.BusProvider;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class ImageDialog extends Dialog {
    private ImageDialogPresenter presenter;
    private int id;

    public ImageDialog(Activity activity, int id) {
        super(activity);
        this.id = id;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_image);
        ButterKnife.bind(this);
        setTitle(null);
        setCancelable(false);

        presenter = new ImageDialogPresenter(new ImageDialogView(this), new ImageDialogModel(BusProvider.getInstance()), id);
    }


    @OnClick(R.id.dialog_buton_back)
    public void onBackClick() {
        dismiss();
    }

    @Override
    protected void onStart() {
        super.onStart();
        BusProvider.register(presenter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        BusProvider.unregister(presenter);
    }
}