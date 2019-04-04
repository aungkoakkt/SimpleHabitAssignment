package com.me.simplehabit.persistence.typeconverters;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.me.simplehabit.data.vos.ProgramVO;

import java.lang.reflect.Type;
import java.util.List;

public class ProgramListConverter {

    @TypeConverter
    public static String fromListToJson(List<ProgramVO> list){
        return new Gson().toJson(list);
    }

    @TypeConverter
    public static List<ProgramVO> fromJsonToList(String data){
        Type typelist=new TypeToken<List<ProgramVO>>(){}.getType();
        return new Gson().fromJson(data,typelist);
    }
}
