package com.me.simplehabit.persistence.typeconverters;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class IntegerListConverter {

    @TypeConverter
    public static String fromListToJson(List<Integer> list){
        return new Gson().toJson(list);
    }

    @TypeConverter
    public static List<Integer> fromJsonToList(String data){
        Type typelist=new TypeToken<List<Integer>>(){}.getType();

        return new Gson().fromJson(data,typelist);
    }
}
