package com.me.simplehabit.data.models;

import com.me.simplehabit.data.vos.CurrentProgramVO;

public interface CurrentProgramModel {

    CurrentProgramVO getCurrentProgram(CurrentProgramDelegate delegate,boolean isForce);

    CurrentProgramVO getCurrentProgram();

    interface CurrentProgramDelegate{

        void onCurrentProgramFetchFromNetwork(CurrentProgramVO currentProgramVO);

        void onErrorOnProgramFetch(String message);
    }
}
