package com.me.simplehabit.data.vos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

import com.google.gson.annotations.SerializedName

@Entity(tableName = "topic", indices = [Index("topic_name", unique = true)])
data class TopicVO(

        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "topic_id")
        val topicId: Int,

        @ColumnInfo(name = "topic_name")
        @SerializedName("topic-name")
        val topicName: String,

        @ColumnInfo(name = "topic_desc")
        @SerializedName("topic-desc")
        val topicDesc: String,

        @ColumnInfo(name = "icon")
        @SerializedName("icon")
        val icon: String,

        @ColumnInfo(name = "background")
        @SerializedName("background")
        val background: String

)
