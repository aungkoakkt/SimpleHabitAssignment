package com.me.simplehabit.persistence.typeconverters;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.me.simplehabit.data.vos.SessionVO;

import java.lang.reflect.Type;
import java.util.List;

public class SessionListConverter {

    @TypeConverter
    public static String fromListToJson(List<SessionVO> sessionList){
        return new Gson().toJson(sessionList);
    }

    @TypeConverter
    public static List<SessionVO> fromJsonToList(String sessions){

        Type listType=new TypeToken<List<SessionVO>>(){}.getType();

        return new Gson().fromJson(sessions,listType);
    }
}
