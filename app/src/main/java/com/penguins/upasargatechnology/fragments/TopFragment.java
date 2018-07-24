package com.penguins.upasargatechnology.fragments;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.penguins.upasargatechnology.R;
import com.penguins.upasargatechnology.helper.UpasargaFragment;


public class TopFragment extends UpasargaFragment implements View.OnClickListener{

    private OnTopFragmentListener onTopFragmentListener;
    private Button topButton;
    private LinearLayout topContainer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_top, container, false);

        initiliseView(view);
        initialiseListener();;

        return view;
    }

    @Override
    protected void initiliseView(View view) {
        topButton = view.findViewById(R.id.top_button);

        topContainer = view.findViewById(R.id.top_container);

    }

    @Override
    protected void initialiseListener() {

        topButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.top_button:

                topContainer.setBackgroundColor(Color.parseColor("#ffffff"));

                onTopFragmentListener.messageFromTopFragment("change_background");

                break;
        }
    }

    public interface OnTopFragmentListener {
        void messageFromTopFragment(String text);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnTopFragmentListener) {
            onTopFragmentListener = (OnTopFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement listeners");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        onTopFragmentListener = null;
    }

    public  void onChangeBackground(String text){

        if (!text.isEmpty()){

            topContainer.setBackgroundColor(Color.parseColor("#a934e4"));

        }


    }



}
