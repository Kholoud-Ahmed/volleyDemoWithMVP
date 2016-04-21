package com.iti.www.pinapp.model.dao.com.iti.www.pinapp.presenter;

import com.iti.www.pinapp.model.dao.MyJson;

/**
 * Created by KHoloud on 4/21/2016.
 */
public interface MainActivityPresenter {


    public void showLoader();


    public void displayResult(MyJson myJson);

    public void hideLoader();



}
