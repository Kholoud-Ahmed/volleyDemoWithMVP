package com.iti.www.pinapp.presenter;

import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;

/**
 * Created by KHoloud on 4/20/2016.
 */
public class MyErrorListener implements Response.ErrorListener {
    @Override
    public void onErrorResponse(VolleyError error) {
        Log.i("****** Error: ",error.getMessage().toString());
    }
}
