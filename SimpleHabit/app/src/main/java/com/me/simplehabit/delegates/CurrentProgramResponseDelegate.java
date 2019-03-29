package com.me.simplehabit.delegates;

import com.me.simplehabit.data.vos.CurrentProgramVO;

public interface CurrentProgramResponseDelegate {

    void onSuccess(CurrentProgramVO currentProgramVO);
    void onFail(String message);
}
