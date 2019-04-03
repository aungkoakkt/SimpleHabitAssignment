package com.me.simplehabit.delegates;

import com.me.simplehabit.data.vos.CategoriesProgramVO;

import java.util.List;

public interface CategoryProgramDelegate {

    void onSuccess(List<CategoriesProgramVO> categoriesProgramVOList);
    void onFail(String message);
}
