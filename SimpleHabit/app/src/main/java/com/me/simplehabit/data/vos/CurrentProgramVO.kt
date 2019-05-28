package com.me.simplehabit.data.vos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

import com.google.gson.annotations.SerializedName

@Entity(tableName = "CurrentProgram", indices = [Index("program_id", unique = true)])
class CurrentProgramVO {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "current_program_id")
    var currentProgramId: Int = 0

    @ColumnInfo(name = "program_id")
    @SerializedName("program-id")
    var programId: String? = null

    @ColumnInfo(name = "title")
    @SerializedName("title")
    var title: String? = null

    @ColumnInfo(name = "current_period")
    @SerializedName("current-period")
    var currentPeriod: String? = null

    @ColumnInfo(name = "background")
    @SerializedName("background")
    var background: String? = null

    @ColumnInfo(name = "average_lengths")
    @SerializedName("average-lengths")
    var averageLengths: List<Int>? = null

    @ColumnInfo(name = "description")
    @SerializedName("description")
    var description: String? = null

    @ColumnInfo(name = "sessions")
    @SerializedName("sessions")
    var sessions: List<SessionVO>? = null
}
