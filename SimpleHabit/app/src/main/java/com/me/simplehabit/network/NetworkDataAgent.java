package com.me.simplehabit.network;

import com.me.simplehabit.delegates.CategoryProgramDelegate;
import com.me.simplehabit.delegates.CurrentProgramResponseDelegate;
import com.me.simplehabit.delegates.TopicResponseDelegate;
import com.me.simplehabit.network.responses.GetCategoriesAndProgramsResponse;
import com.me.simplehabit.network.responses.GetCurrentProgramResponse;
import com.me.simplehabit.network.responses.GetTopicResponse;
import com.me.simplehabit.utils.CommonInstances;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkDataAgent implements SimpleHabitDataAgent {

    private static NetworkDataAgent objInstance;

    private final SimpleHabitAPI theApi;

    private NetworkDataAgent() {

        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://padcmyanmar.com/padc-5/simple-habits/")
                .addConverterFactory(GsonConverterFactory.create(CommonInstances.getGsonInstance()))
                .client(okHttpClient)
                .build();

        theApi = retrofit.create(SimpleHabitAPI.class);

    }

    public static NetworkDataAgent getInstance() {
        return (objInstance == null) ? objInstance = new NetworkDataAgent() : objInstance;
    }


    @Override
    public void getCurrentProgram(String token, int page, final CurrentProgramResponseDelegate delegate) {

        theApi.loadCurrentProgram(token, page).enqueue(new Callback<GetCurrentProgramResponse>() {
            @Override
            public void onResponse(Call<GetCurrentProgramResponse> call, Response<GetCurrentProgramResponse> response) {
                GetCurrentProgramResponse currentProgramResponse = response.body();

                if (currentProgramResponse != null) {

                    if (currentProgramResponse.isResponseSuccess()) {
                        delegate.onSuccess(currentProgramResponse.getCurrentProgram());
                    } else {
                        delegate.onFail(currentProgramResponse.getMessage());
                    }
                } else {
                    delegate.onFail("Current Program Response is null");
                }
            }

            @Override
            public void onFailure(Call<GetCurrentProgramResponse> call, Throwable t) {
                delegate.onFail(t.getMessage());
            }
        });
    }

    @Override
    public void getTopics(String token, int page, final TopicResponseDelegate delegate) {

        theApi.loadTopics(token, page).enqueue(new Callback<GetTopicResponse>() {
            @Override
            public void onResponse(Call<GetTopicResponse> call, Response<GetTopicResponse> response) {
                GetTopicResponse topicResponse = response.body();

                if (topicResponse != null) {

                    if (topicResponse.isResponseSuccess()) {
                        delegate.onSuccess(topicResponse.getTopics());
                    } else {
                        delegate.onFail(topicResponse.getMessage());
                    }
                } else {
                    delegate.onFail("Current Program Response is null");
                }
            }

            @Override
            public void onFailure(Call<GetTopicResponse> call, Throwable t) {
                delegate.onFail(t.getMessage());
            }
        });
    }

    @Override
    public void getCategoriesAndPrograms(String token, int page, final CategoryProgramDelegate delegate) {

        theApi.loadCategoriesAdnPrograms(token,page).enqueue(new Callback<GetCategoriesAndProgramsResponse>() {
            @Override
            public void onResponse(Call<GetCategoriesAndProgramsResponse> call, Response<GetCategoriesAndProgramsResponse> response) {
                GetCategoriesAndProgramsResponse categoriesAndProgramsResponse=response.body();

                if (categoriesAndProgramsResponse!=null){
                    if (categoriesAndProgramsResponse.isResponseSuccess()){
                        delegate.onSuccess(categoriesAndProgramsResponse.getCategoriesPrograms());
                    }else {
                        delegate.onFail(categoriesAndProgramsResponse.getMessage());
                    }
                }else {
                    delegate.onFail("Category and Program is null");
                }
            }

            @Override
            public void onFailure(Call<GetCategoriesAndProgramsResponse> call, Throwable t) {

            }
        });
    }
}
