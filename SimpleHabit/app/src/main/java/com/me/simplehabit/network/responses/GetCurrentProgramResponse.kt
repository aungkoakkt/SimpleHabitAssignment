package com.me.simplehabit.network.responses

import com.google.gson.annotations.SerializedName
import com.me.simplehabit.data.vos.CurrentProgramVO

data class GetCurrentProgramResponse(

        @SerializedName("currentProgram")
        val currentProgram: CurrentProgramVO

) : BaseResponse()
