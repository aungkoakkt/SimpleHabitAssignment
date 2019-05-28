package com.me.simplehabit.data.vos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

import com.google.gson.annotations.SerializedName

@Entity(tableName = "topic", indices = [Index( "topic_name", unique = true)])
class TopicVO {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "topic_id")
    var topicId: Int = 0

    @ColumnInfo(name = "topic_name")
    @SerializedName("topic-name")
    var topicName: String? = null

    @ColumnInfo(name = "topic_desc")
    @SerializedName("topic-desc")
    var topicDesc: String? = null

    @ColumnInfo(name = "icon")
    @SerializedName("icon")
    var icon: String? = null

    @ColumnInfo(name = "background")
    @SerializedName("background")
    var background: String? = null

}
