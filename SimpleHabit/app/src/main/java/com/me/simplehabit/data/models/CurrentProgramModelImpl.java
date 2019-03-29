package com.me.simplehabit.data.models;

import com.me.simplehabit.data.vos.CurrentProgramVO;
import com.me.simplehabit.delegates.CurrentProgramResponseDelegate;
import com.me.simplehabit.network.NetworkDataAgent;
import com.me.simplehabit.network.SimpleHabitDataAgent;
import com.me.simplehabit.utils.CommonInstances;

public class CurrentProgramModelImpl extends BaseModel implements CurrentProgramModel {

    private static CurrentProgramModelImpl objInstance;

    private CurrentProgramVO currentProgramVO;

    private SimpleHabitDataAgent dataAgent;

    private CurrentProgramModelImpl() {
        currentProgramVO = null;
        dataAgent = NetworkDataAgent.getInstance();
    }

    public static CurrentProgramModelImpl getInstance() {
        return (objInstance == null) ? objInstance = new CurrentProgramModelImpl(): objInstance;
    }

    @Override
    public CurrentProgramVO getCurrentProgram(final CurrentProgramDelegate delegate, boolean isForce) {

        if (currentProgramVO==null || isForce){
            dataAgent.getCurrentProgram(CommonInstances.TOKEN,CommonInstances.PAGE, new CurrentProgramResponseDelegate() {
                @Override
                public void onSuccess(CurrentProgramVO currentProgramVO) {
                    delegate.onCurrentProgramFetchFromNetwork(currentProgramVO);
                }

                @Override
                public void onFail(String message) {
                    delegate.onErrorOnProgramFetch(message);
                }
            });
        }else {
            return currentProgramVO;
        }
        return null;
    }
}
