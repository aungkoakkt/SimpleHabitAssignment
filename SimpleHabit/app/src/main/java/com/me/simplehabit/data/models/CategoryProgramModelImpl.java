package com.me.simplehabit.data.models;

import com.me.simplehabit.data.vos.CategoriesProgramVO;
import com.me.simplehabit.delegates.CategoryProgramDelegate;
import com.me.simplehabit.network.NetworkDataAgent;
import com.me.simplehabit.network.SimpleHabitDataAgent;
import com.me.simplehabit.utils.CommonInstances;

import java.util.ArrayList;
import java.util.List;

public class CategoryProgramModelImpl implements CategoryProgramModel {

    private static CategoryProgramModelImpl objInstance;

    private List<CategoriesProgramVO> categoriesProgramVOList;

    private SimpleHabitDataAgent dataAgent;

    private CategoryProgramModelImpl() {
        categoriesProgramVOList = new ArrayList<>();
        dataAgent = NetworkDataAgent.getInstance();
    }

    public static CategoryProgramModelImpl getInstance() {
        return (objInstance == null) ? objInstance = new CategoryProgramModelImpl(): objInstance;
    }

    @Override
    public List<CategoriesProgramVO> getCategoriesAndProgram(final CategoryProgramModelDelegate delegate, boolean isForce) {

        if (categoriesProgramVOList.isEmpty() || isForce){

            dataAgent.getCategoriesAndPrograms(CommonInstances.TOKEN, CommonInstances.PAGE, new CategoryProgramDelegate() {
                @Override
                public void onSuccess(List<CategoriesProgramVO> categoriesProgramVOList) {
                    delegate.onCurrentProgramFetchFromNetwork(categoriesProgramVOList);
                }

                @Override
                public void onFail(String message) {
                    delegate.onErrorOnProgramFetch(message);
                }
            });

        }else{
            return categoriesProgramVOList;
        }
        return categoriesProgramVOList;
    }
}
