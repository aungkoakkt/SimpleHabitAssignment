package com.me.simplehabit.data.vos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

import com.google.gson.annotations.SerializedName

@Entity(tableName = "CurrentProgram", indices = [Index("program_id", unique = true)])
data class CurrentProgramVO(

        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "current_program_id")
        val currentProgramId: Int,

        @ColumnInfo(name = "program_id")
        @SerializedName("program-id")
        val programId: String,

        @ColumnInfo(name = "title")
        @SerializedName("title")
        val title: String,

        @ColumnInfo(name = "current_period")
        @SerializedName("current-period")
        var currentPeriod: String,

        @ColumnInfo(name = "background")
        @SerializedName("background")
        var background: String,

        @ColumnInfo(name = "average_lengths")
        @SerializedName("average-lengths")
        var averageLengths: List<Int>,

        @ColumnInfo(name = "description")
        @SerializedName("description")
        var description: String,

        @ColumnInfo(name = "sessions")
        @SerializedName("sessions")
        var sessions: List<SessionVO>
)
