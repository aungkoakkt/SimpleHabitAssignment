package com.me.simplehabit.data.vos;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@Entity(tableName = "category_program", indices = {@Index(value = "category_id", unique = true)})
public class CategoriesProgramVO {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "category_program_id")
    private int categoryProgramId;

    @ColumnInfo(name = "category_id")
    @SerializedName("category-id")
    private String categoryId;

    @ColumnInfo(name = "title")
    @SerializedName("title")
    private String title;

    @ColumnInfo(name = "program_list")
    @SerializedName("programs")
    private List<ProgramVO> programs = null;

    public int getCategoryProgramId() {
        return categoryProgramId;
    }

    public void setCategoryProgramId(int categoryProgramId) {
        this.categoryProgramId = categoryProgramId;
    }

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
