package com.iti.www.pinapp.views.activities;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import com.android.volley.toolbox.NetworkImageView;
import com.iti.www.pinapp.R;
import com.iti.www.pinapp.model.dao.MyJson;
import com.iti.www.pinapp.model.dao.com.iti.www.pinapp.presenter.MainActivityPresenter;
import com.iti.www.pinapp.presenter.Presenter;
import java.net.URL;

public class MainActivity extends Activity implements MainActivityPresenter {

    TextView textView;
//    Button button;
    NetworkImageView networkImageView;
    URL url;
    Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
    }


    private void initComponents() {
        textView = (TextView) findViewById(R.id.tvMainActivity);
//        button = (Button) findViewById(R.id.bMainActivity);
        networkImageView = (NetworkImageView) findViewById(R.id.networkImageViewMainActivity);
        presenter = new Presenter(this);
    }

    @Override
    public void showLoader() {

    }

    @Override
    public void displayResult(MyJson myJson) {
        Log.i("*****json in main **** ","message: "+myJson.getMessage()+" code: "+myJson.getCode()+" images: "+myJson.getImages());
        textView.setText("message: " + myJson.getMessage() + " code: " + myJson.getCode() + " images: " + myJson.getImages());
        networkImageView.setImageUrl("http://assets.chrisblunt.com/wp-content/uploads/2012/12/IMG_20120619_202506-e1356946615784.jpg" ,presenter.getImageLoader());
        networkImageView.setDefaultImageResId(R.drawable.plus);
    }

    @Override
    public void hideLoader() {

    }
}
