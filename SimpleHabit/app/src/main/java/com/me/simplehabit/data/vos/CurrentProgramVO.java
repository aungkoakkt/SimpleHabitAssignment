package com.me.simplehabit.data.vos;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@Entity(tableName = "CurrentProgram",indices = { @Index( value = "program_id",unique = true)})
public class CurrentProgramVO {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "current_program_id")
    private int currentProgramId;

    @ColumnInfo(name = "program_id")
    @SerializedName("program-id")
    private String programId;

    @ColumnInfo(name = "title")
    @SerializedName("title")
    private String title;

    @ColumnInfo(name = "current_period")
    @SerializedName("current-period")
    private String currentPeriod;

    @ColumnInfo(name = "background")
    @SerializedName("background")
    private String background;

    @ColumnInfo(name = "average_lengths")
    @SerializedName("average-lengths")
    private List<Integer> averageLengths = null;

    @ColumnInfo(name = "description")
    @SerializedName("description")
    private String description;

    @ColumnInfo(name = "sessions")
    @SerializedName("sessions")
    private List<SessionVO> sessions = null;

    public String getProgramId() {
        return programId;
    }

    public void setProgramId(String programId) {
        this.programId = programId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCurrentPeriod() {
        return currentPeriod;
    }

    public void setCurrentPeriod(String currentPeriod) {
        this.currentPeriod = currentPeriod;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public List<Integer> getAverageLengths() {
        return averageLengths;
    }

    public void setAverageLengths(List<Integer> averageLengths) {
        this.averageLengths = averageLengths;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<SessionVO> getSessions() {
        return sessions;
    }

    public void setSessions(List<SessionVO> sessions) {
        this.sessions = sessions;
    }

    public int getCurrentProgramId() {
        return currentProgramId;
    }

    public void setCurrentProgramId(int currentProgramId) {
        this.currentProgramId = currentProgramId;
    }
}
