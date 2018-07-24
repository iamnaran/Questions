package com.penguins.upasargatechnology.helper;

import android.view.View;

/**
 * Created by NaRan on 01,May,2018.
 * Copyright (c) inGrails Pvt. Ltd. All rights reserved.
 * nrn.panthi@gmail.com
 **/

public abstract class UpasargaFragment extends android.support.v4.app.Fragment {

    abstract protected void initiliseView(View view);

    abstract protected void initialiseListener();

}
