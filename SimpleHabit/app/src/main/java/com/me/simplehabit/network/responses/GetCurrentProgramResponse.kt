package com.me.simplehabit.network.responses

import com.google.gson.annotations.SerializedName
import com.me.simplehabit.data.vos.CurrentProgramVO

class GetCurrentProgramResponse : BaseResponse() {

    @SerializedName("currentProgram")
    var currentProgram: CurrentProgramVO? = null
}
