package com.me.simplehabit.network.responses;

import com.google.gson.annotations.SerializedName;
import com.me.simplehabit.data.vos.CurrentProgramVO;

public class GetCurrentProgramResponse extends BaseResponse{

    @SerializedName("currentProgram")
    private CurrentProgramVO currentProgram;

    public CurrentProgramVO getCurrentProgram() {
        return currentProgram;
    }

    public void setCurrentProgram(CurrentProgramVO currentProgram) {
        this.currentProgram = currentProgram;
    }
}
