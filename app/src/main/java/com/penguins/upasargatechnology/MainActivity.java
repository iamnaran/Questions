package com.penguins.upasargatechnology;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;

import com.penguins.upasargatechnology.fragments.BottomFragment;
import com.penguins.upasargatechnology.fragments.TopFragment;
import com.penguins.upasargatechnology.helper.UpasargaActivity;

public class MainActivity extends UpasargaActivity implements TopFragment.OnTopFragmentListener , BottomFragment.OnBottomfragmentListener{


    private static final String TOP_TAG = "top";
    private static final String BOTTOM_TAG = "bottom";
    private TopFragment topFragment;
    private BottomFragment bottomfragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initiliseView();
        initialiseListener();
        setUpFragments();
    }



    @Override
    protected void initiliseView() {

    }

    @Override
    protected void initialiseListener() {

    }

    private void setUpFragments() {

        FragmentManager fragmentManager = getSupportFragmentManager();

        topFragment = (TopFragment) fragmentManager.findFragmentByTag(TOP_TAG);
        if (topFragment == null) {
            topFragment = new TopFragment();
            fragmentManager.beginTransaction().add(R.id.top_fragment_container, topFragment, TOP_TAG).commit();
        }

        bottomfragment = (BottomFragment) fragmentManager.findFragmentByTag(BOTTOM_TAG);
        if (bottomfragment == null) {
            bottomfragment = new BottomFragment();
            fragmentManager.beginTransaction().add(R.id.bottom_fragment_container, bottomfragment, BOTTOM_TAG).commit();
        }



    }


    @Override
    public void messageFromTopFragment(String text) {

        bottomfragment.onChangeBackground(text);

    }

    @Override
    public void messageFromBottomFragment(String text) {

        topFragment.onChangeBackground(text);

    }
}
