package com.android5learn.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.transition.Explode;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

import com.android5learn.adapter.HomeRecyclerAdapter;
import com.android5learn.application.MyApplication;
import com.myapp.android5Learn.R;

public class HomeActivity extends Activity {

    private Button buttonStart;
    private CardView cardView;
    private RecyclerView recyclerView;

    private LayoutManager mLayoutManager;
    private HomeRecyclerAdapter mAdapter;
    private String[] dataSet = {"北京奥运0", "北京奥运北京奥运1", "北京奥运北京奥运北京奥运2", "北京奥运3",
            "北京奥运4北京奥运北京奥运北京奥运", "北京奥运5", "北京奥运6北京奥运北京奥运北京奥运北京奥运", "北京奥运7", "北京奥运8",
            "北京奥运北京奥运北京奥运9", "北京奥运10", "北京奥运11", "北京奥运北京奥运12", "北京奥运13", "北京奥运14", "北京奥运15",
            "北京奥运北京奥运16", "北京奥运17", "北京奥运北京奥运北京奥运北京奥运18", "北京奥运19", "北京奥运20"};

    @SuppressLint("InlinedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (MyApplication.isLollipop) {
            getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        }

        setContentView(R.layout.activity_home);

        initView();
        initData();
    }

    @SuppressLint("NewApi")
    private void initView() {
        // button
        buttonStart = (Button) findViewById(R.id.button_start);
        buttonStart.setOnClickListener(new OnClickListener() {

            @SuppressWarnings("unchecked")
            @SuppressLint("NewApi")
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, SecondActivity.class);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    getWindow().setExitTransition(new Explode());
                    startActivity(intent,
                            ActivityOptions.makeSceneTransitionAnimation(HomeActivity.this)
                                    .toBundle());
                } else {
                    startActivity(intent);
                }
            }
        });
        // use in api21
        // buttonStart.setClipToOutline(true);

        // cardView
        cardView = (CardView) findViewById(R.id.cardView);
        // must set cardMaxElevation(xml/code) before setCardElevation
        cardView.setCardElevation(24f);
        // use in api21
        // cardView.setTranslationZ(20);

        // TODO
        // cardView.setOutlineProvider(null);
        // cardView.setOutlineProvider(new ViewOutlineProvider() {
        //
        // @Override
        // public void getOutline(View view, Outline outline) {
        // }
        // });

        // recyclerView
        recyclerView = (RecyclerView) findViewById(R.id.recycleView);
        recyclerView.setHasFixedSize(true);

        // LinearLayoutManager
        mLayoutManager = new LinearLayoutManager(HomeActivity.this);
        mLayoutManager =
                new LinearLayoutManager(HomeActivity.this, LinearLayoutManager.HORIZONTAL, false);

        // GridLayoutManager
        mLayoutManager = new GridLayoutManager(HomeActivity.this, 2);
        mLayoutManager =
                new GridLayoutManager(HomeActivity.this, 2, LinearLayoutManager.VERTICAL, false);

        // StaggeredGridLayoutManager
        mLayoutManager = new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
        ((StaggeredGridLayoutManager) mLayoutManager)
                .setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);

        recyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new HomeRecyclerAdapter(dataSet);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        // StateListAnimator
        // TODO
        // StateListAnimator stateListAnimator = new StateListAnimator();
    }

    private void initData() {}
}
