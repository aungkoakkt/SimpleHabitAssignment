package com.me.simplehabit.network.responses;

import com.google.gson.annotations.SerializedName;
import com.me.simplehabit.data.vos.CurrentProgramVO;

public class GetCurrentProgramResponse {

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("apiVersion")
    private String apiVersion;

    @SerializedName("currentProgram")
    private CurrentProgramVO currentProgram;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    public CurrentProgramVO getCurrentProgram() {
        return currentProgram;
    }

    public void setCurrentProgram(CurrentProgramVO currentProgram) {
        this.currentProgram = currentProgram;
    }

    public boolean isResonseSuccess(){
        return code==200;
    }
}
