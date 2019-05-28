package com.me.simplehabit.persistence.typeconverters

import androidx.room.TypeConverter

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

import java.lang.reflect.Type

class IntegerListConverter {

    @TypeConverter
    fun fromListToJson(list: List<Int>): String {
        return Gson().toJson(list)
    }

    @TypeConverter
    fun fromJsonToList(data: String): List<Int>? {
        val typelist = object : TypeToken<List<Int>>() {

        }.type

        return Gson().fromJson<List<Int>>(data, typelist)
    }
}
