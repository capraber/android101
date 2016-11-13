package com.globant.android101.mvp.view;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.globant.android101.MainActivity;
import com.globant.android101.R;
import com.globant.android101.adapters.PhotoAdapter;
import com.globant.android101.model.Item;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PhotoView extends ActivityView {

    public PhotoView(AppCompatActivity activity) {
        super(activity);
    }

    @BindView(R.id.my_recycler_view) RecyclerView recyclerView;

    public PhotoView(MainActivity activity) {
        super(activity);
        ButterKnife.bind(this, activity);

        recyclerView.setAdapter(new PhotoAdapter(new ArrayList<Item>()));
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(llm);
    }

    public void setAdapter(PhotoAdapter adapter) {
        recyclerView.setAdapter(adapter);
        recyclerView.invalidate();
    }
}
