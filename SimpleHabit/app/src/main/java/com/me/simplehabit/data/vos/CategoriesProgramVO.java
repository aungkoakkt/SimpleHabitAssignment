package com.me.simplehabit.data.vos;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CategoriesProgramVO {

    @SerializedName("category-id")
    private String categoryId;

    @SerializedName("title")
    private String title;

    @SerializedName("programs")
    private List<ProgramVO> programs = null;

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<ProgramVO> getPrograms() {
        return programs;
    }

    public void setPrograms(List<ProgramVO> programs) {
        this.programs = programs;
    }

}
