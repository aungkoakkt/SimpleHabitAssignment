package com.me.simplehabit.persistence.typeconverters

import androidx.room.TypeConverter

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.me.simplehabit.data.vos.ProgramVO

import java.lang.reflect.Type

class ProgramListConverter {

    @TypeConverter
    fun fromListToJson(list: List<ProgramVO>): String {
        return Gson().toJson(list)
    }

    @TypeConverter
    fun fromJsonToList(data: String): List<ProgramVO>? {
        val listType = object : TypeToken<List<ProgramVO>>() {

        }.type
        return Gson().fromJson<List<ProgramVO>>(data, listType)
    }
}
