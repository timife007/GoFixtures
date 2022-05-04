package com.timothy.gofixtures.data.cache.model

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class TypeConverters {
    private val gson = Gson()

    /**
     *     Converts a listOf[Category] to [String]
     */
    @TypeConverter
    fun fromAny(value: Any): String {
        val type = object : TypeToken<Any>() {}.type
        return gson.toJson(value, type)
    }

    //Converts a [String] to a listOf[Category]
    @TypeConverter
    fun toAny(value: String): Any {
        val type = object : TypeToken<Any>() {}.type
        return gson.fromJson(value, type)!!
    }
}