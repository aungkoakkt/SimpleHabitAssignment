package com.me.simplehabit.data.vos

import com.google.gson.annotations.SerializedName

class ProgramVO {

    @SerializedName("program-id")
    var programId: String? = null

    @SerializedName("title")
    var title: String? = null

    @SerializedName("image")
    var image: String? = null

    @SerializedName("average-lengths")
    var averageLengths: List<Int>? = null

    @SerializedName("description")
    var description: String? = null

    @SerializedName("sessions")
    var sessions: List<SessionVO>? = null
}
