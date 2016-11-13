package com.globant.android101;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.globant.android101.mvp.model.PhotoModel;
import com.globant.android101.mvp.presenter.PhotoPresenter;
import com.globant.android101.mvp.view.PhotoView;
import com.globant.android101.utils.BusProvider;

public class MainActivity extends AppCompatActivity {

    PhotoPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (presenter == null) {
            presenter = new PhotoPresenter(new PhotoModel(BusProvider.getInstance()), new PhotoView(this));
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
}
