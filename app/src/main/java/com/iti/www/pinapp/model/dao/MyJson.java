package com.iti.www.pinapp.model.dao;

/**
 * Created by KHoloud on 4/20/2016.
 */
public class MyJson {
    private String message;
    private String code;
    private String images;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    @Override
    public String toString() {
        return "MyJson{" +
                "message='" + message + '\'' +
                ", code='" + code + '\'' +
                ", images='" + images + '\'' +
                '}';
    }
}
