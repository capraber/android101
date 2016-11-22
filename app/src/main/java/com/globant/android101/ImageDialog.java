package com.globant.android101;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import com.globant.android101.mvp.model.ImageDialogModel;
import com.globant.android101.mvp.presenter.ImageDialogPresenter;
import com.globant.android101.mvp.view.ImageDialogView;
import com.globant.android101.utils.BusProvider;
import com.globant.android101.utils.ServiceUtils;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class ImageDialog extends Dialog {
    private ImageDialogPresenter presenter;
    private int id;

    public ImageDialog(Context context, int id) {
        super(context);
        this.id = id;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_image);
        ButterKnife.bind(this);
        setTitle(null);
        setCancelable(false);

        presenter = new ImageDialogPresenter(new ImageDialogView(this), new ImageDialogModel(ServiceUtils.getItemService(), id));
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