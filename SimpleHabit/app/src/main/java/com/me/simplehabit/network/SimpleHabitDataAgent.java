package com.me.simplehabit.network;

import com.me.simplehabit.delegates.CategoryProgramDelegate;
import com.me.simplehabit.delegates.CurrentProgramResponseDelegate;
import com.me.simplehabit.delegates.TopicResponseDelegate;

public interface SimpleHabitDataAgent {

    void getCurrentProgram(String token, int page, CurrentProgramResponseDelegate delegate);
    void getTopics(String token, int page, TopicResponseDelegate delegate);
    void getCategoriesAndPrograms(String token, int page, CategoryProgramDelegate delegate);
}
