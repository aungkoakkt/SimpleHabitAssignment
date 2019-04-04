package com.me.simplehabit.data.models;

import android.content.Context;

import com.me.simplehabit.data.vos.CurrentProgramVO;
import com.me.simplehabit.delegates.CurrentProgramResponseDelegate;
import com.me.simplehabit.utils.CommonInstances;

public class CurrentProgramModelImpl extends BaseModel implements CurrentProgramModel {

    private static CurrentProgramModelImpl objInstance;

    private CurrentProgramModelImpl(Context context){
        super(context);
    }

    public static void initCurrentProgramModel(Context context){
        objInstance=new CurrentProgramModelImpl(context);
    }

    public static CurrentProgramModelImpl getInstance() {
        if (objInstance == null) {
            throw  new RuntimeException("CurrentProgramModel should have been initialized before using it");
        }
        return objInstance;
    }

    @Override
    public CurrentProgramVO getCurrentProgram(final CurrentProgramDelegate delegate, boolean isForce) {

        if (mDatabase.isCurrentProgramEmpty() || isForce){
            mDataAgent.getCurrentProgram(CommonInstances.TOKEN, CommonInstances.PAGE, new CurrentProgramResponseDelegate() {
                @Override
                public void onSuccess(CurrentProgramVO currentProgramVO) {
                    mDatabase.getCurrentProgramDao().saveCurrentProgram(currentProgramVO);
                    delegate.onCurrentProgramFetchFromNetwork(currentProgramVO);
                }

                @Override
                public void onFail(String message) {
                    delegate.onErrorOnProgramFetch(message);
                }
            });
        }else {
            return mDatabase.getCurrentProgramDao().retrieveCurrentProgram();
        }

        return null;
    }

    @Override
    public CurrentProgramVO getCurrentProgram() {
        if (!mDatabase.isCurrentProgramEmpty()){
            return mDatabase.getCurrentProgramDao().retrieveCurrentProgram();
        }
        return null;
    }
}
