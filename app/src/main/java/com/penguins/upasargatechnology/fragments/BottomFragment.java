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


public class BottomFragment extends UpasargaFragment implements View.OnClickListener{


    private LinearLayout bottomContainer;
    private Button bottomButton;
    OnBottomfragmentListener onBottomfragmentListener;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bottom, container, false);
        initiliseView(view);
        initialiseListener();

        return view;
    }


    @Override
    protected void initiliseView(View view) {
        bottomContainer = view.findViewById(R.id.bottom_container);
        bottomButton = view.findViewById(R.id.bottom_button);

    }

    @Override
    protected void initialiseListener() {
        bottomButton.setOnClickListener(this);

    }

    public  void onChangeBackground(String text){

        if (!text.isEmpty()){

            bottomContainer.setBackgroundColor(Color.parseColor("#a934e4"));

        }


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.bottom_button:

                bottomContainer.setBackgroundColor(Color.parseColor("#ffffff"));

                onBottomfragmentListener.messageFromBottomFragment("Dont change");




                break;

        }
    }

     public interface OnBottomfragmentListener{

        void messageFromBottomFragment(String text);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnBottomfragmentListener) {
            onBottomfragmentListener = (OnBottomfragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnGreenFragmentListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        onBottomfragmentListener = null;
    }
}
