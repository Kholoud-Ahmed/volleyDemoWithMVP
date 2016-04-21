package com.iti.www.pinapp.presenter;

import android.graphics.Bitmap;
import android.util.Log;
import android.util.LruCache;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.iti.www.pinapp.model.dao.MyJson;
import com.iti.www.pinapp.views.activities.MainActivity;

import org.json.JSONException;
import org.json.JSONObject;


/**
 * Created by KHoloud on 4/20/2016.
 */
public class Presenter {

    private MainActivity mainActivity;
    private ImageLoader imageLoader;
    private MyJson returnedJson;


    public Presenter(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        createVolley();
    }

    public ImageLoader getImageLoader() {
        return imageLoader;
    }

    public void setImageLoader(ImageLoader imageLoader) {
        this.imageLoader = imageLoader;
    }

    public MyJson getReturnedJson() {
        return returnedJson;
    }

    public void setReturnedJson(MyJson returnedJson) {
        this.returnedJson = returnedJson;
    }

    public void createVolley(){
        final RequestQueue requestQueue = Volley.newRequestQueue(mainActivity);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest("http://cblunt.github.io/blog-android-volley/response.json",null,
                new Response.Listener<JSONObject>(){

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.i("******** Response: ",response.toString());
                        try {
                            String message = response.getString("message");
                            String code = response.getString("code");
                            String images = response.getString("images");
                            MyJson myJson = new MyJson();
                            myJson.setMessage(message);
                            myJson.setCode(code);
                            myJson.setImages(images);

                            imageLoader = new ImageLoader(requestQueue, new ImageLoader.ImageCache() {
                                private final LruCache<String, Bitmap> mCache = new LruCache<String, Bitmap>(10);
                                public void putBitmap(String url, Bitmap bitmap) {
                                    mCache.put(url, bitmap);
                                }
                                public Bitmap getBitmap(String url) {
                                    return mCache.get(url);
                                }
                            });

                            mainActivity.displayResult(myJson);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new MyErrorListener()
        );
        requestQueue.add(jsonObjectRequest);
    }
}
