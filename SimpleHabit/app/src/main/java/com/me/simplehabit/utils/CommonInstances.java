package com.me.simplehabit.utils;


import com.google.gson.Gson;

/**
 * Created by aung on 12/12/15.
 */
public class CommonInstances {

    public static final String TOKEN = "b002c7e1a528b7cb460933fc2875e916";
    public static final int PAGE=1;

    private static Gson gson = new Gson();

    public static Gson getGsonInstance() {
        return gson;
    }
}
