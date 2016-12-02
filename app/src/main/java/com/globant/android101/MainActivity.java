package com.globant.android101;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.globant.android101.mvp.model.PhotoModel;
import com.globant.android101.mvp.presenter.PhotoPresenter;
import com.globant.android101.mvp.view.PhotoView;
import com.globant.android101.utils.BusProvider;
import com.globant.android101.utils.ServiceUtils;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    PhotoPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        if (presenter == null) {
            presenter = new PhotoPresenter(new PhotoModel(ServiceUtils.getItemService()), new PhotoView(this));
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        BusProvider.unregister(presenter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        BusProvider.register(presenter);
    }

    @OnClick(R.id.floating)
    public void onFloatingClick() {
        presenter.showMapa();
    }

}
