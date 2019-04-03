package com.me.simplehabit.network;

import com.me.simplehabit.network.responses.GetCategoriesAndProgramsResponse;
import com.me.simplehabit.network.responses.GetCurrentProgramResponse;
import com.me.simplehabit.network.responses.GetTopicResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface SimpleHabitAPI {

    @FormUrlEncoded
    @POST("getCurrentProgram.php")
    Call<GetCurrentProgramResponse> loadCurrentProgram(@Field("access_token") String accessToken, @Field("page") int page);

    @FormUrlEncoded
    @POST("getTopics.php")
    Call<GetTopicResponse> loadTopics(@Field("access_token") String accessToken, @Field("page") int page);

    @FormUrlEncoded
    @POST("getCategoriesPrograms.php")
    Call<GetCategoriesAndProgramsResponse> loadCategoriesAdnPrograms(@Field("access_token") String accessToken, @Field("page") int page);


}
