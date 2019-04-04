package com.me.simplehabit.data.models;

import android.content.Context;

import com.me.simplehabit.data.vos.CategoriesProgramVO;
import com.me.simplehabit.delegates.CategoryProgramDelegate;
import com.me.simplehabit.utils.CommonInstances;

import java.util.List;

public class CategoryProgramModelImpl extends BaseModel implements CategoryProgramModel {

    private static CategoryProgramModelImpl objInstance;

    private CategoryProgramModelImpl(Context context) {
        super(context);
    }

    public static void initCategoryProgramModel(Context context){
        objInstance=new CategoryProgramModelImpl(context);
    }
    public static CategoryProgramModelImpl getInstance() {
        if (objInstance == null) {
            throw  new RuntimeException("CategoryProgramModel should have been initialized before using it");
        }
        return objInstance;
    }

    @Override
    public List<CategoriesProgramVO> getCategoriesAndProgram(final CategoryProgramModelDelegate delegate, boolean isForce) {

        if (mDatabase.isCategoiresAndProgramsEmpty() || isForce){

            mDataAgent.getCategoriesAndPrograms(CommonInstances.TOKEN, CommonInstances.PAGE, new CategoryProgramDelegate() {
                @Override
                public void onSuccess(List<CategoriesProgramVO> categoriesProgramVOList) {
                    delegate.onCurrentProgramFetchFromNetwork(categoriesProgramVOList);
                    mDatabase.getCategoryProgramDao().savecategoriesAndPrograms(categoriesProgramVOList);
                }

                @Override
                public void onFail(String message) {
                    delegate.onErrorOnProgramFetch(message);
                }
            });

        }else {
            return mDatabase.getCategoryProgramDao().retrieveCategoriesAndPrograms();
        }

        return null;
    }

    @Override
    public CategoriesProgramVO getCategoriesAndProgramById(String categoryId) {
        if (!mDatabase.isCategoiresAndProgramsEmpty()){
            return mDatabase.getCategoryProgramDao().retrieveCategoryById(categoryId);
        }
        return null;
    }
}
