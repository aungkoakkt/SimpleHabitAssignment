package com.me.simplehabit.data.models;

import com.me.simplehabit.data.vos.CategoriesProgramVO;

import java.util.List;

public interface CategoryProgramModel {

    List<CategoriesProgramVO> getCategoriesAndProgram(CategoryProgramModelDelegate delegate,boolean isForce);
    CategoriesProgramVO getCategoriesAndProgramById(String categoryId);

    interface CategoryProgramModelDelegate{

        void onCurrentProgramFetchFromNetwork(List<CategoriesProgramVO> categoriesProgramVOList);

        void onErrorOnProgramFetch(String message);
    }
}
