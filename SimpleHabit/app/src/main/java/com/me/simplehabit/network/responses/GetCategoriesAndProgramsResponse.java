package com.me.simplehabit.network.responses;

import com.google.gson.annotations.SerializedName;
import com.me.simplehabit.data.vos.CategoriesProgramVO;

import java.util.List;

public class GetCategoriesAndProgramsResponse extends BaseResponse{

    @SerializedName("page")
    private String page;

    @SerializedName("categoriesPrograms")
    private List<CategoriesProgramVO> categoriesPrograms = null;

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public List<CategoriesProgramVO> getCategoriesPrograms() {
        return categoriesPrograms;
    }

    public void setCategoriesPrograms(List<CategoriesProgramVO> categoriesPrograms) {
        this.categoriesPrograms = categoriesPrograms;
    }

}
