package com.globant.android101.mvp.view;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.globant.android101.MainActivity;
import com.globant.android101.R;
import com.globant.android101.adapters.PhotoAdapter;
import com.globant.android101.model.Item;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PhotoView extends ActivityView {

    @BindView(R.id.my_recycler_view) RecyclerView recyclerView;
    @BindView(R.id.progressBar) ProgressBar progressBar;

    public PhotoView(MainActivity activity) {
        super(activity);
        ButterKnife.bind(this, activity);

        recyclerView.setAdapter(new PhotoAdapter(new ArrayList<Item>()));
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(llm);
    }

    public void setAdapter(PhotoAdapter adapter) {
        progressBar.setVisibility(View.GONE);
        recyclerView.setAdapter(adapter);
        recyclerView.invalidate();
    }
}
