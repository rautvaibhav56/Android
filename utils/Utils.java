package com.sunbeam.myproject2.utils;

public class Utils {

    public static String getUrl(String route) {
        return Constants.SERVER_URL + route;
    }

    public static String getImageUrl(String image) {
        return Constants.SERVER_URL + image;
    }
}
