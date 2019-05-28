package com.me.simplehabit.network

import com.me.simplehabit.network.responses.GetCategoriesAndProgramsResponse
import com.me.simplehabit.network.responses.GetCurrentProgramResponse
import com.me.simplehabit.network.responses.GetTopicResponse

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface SimpleHabitAPI {

    @FormUrlEncoded
    @POST("getCurrentProgram.php")
    fun loadCurrentProgram(@Field("access_token") accessToken: String, @Field("page") page: Int): Call<GetCurrentProgramResponse>

    @FormUrlEncoded
    @POST("getTopics.php")
    fun loadTopics(@Field("access_token") accessToken: String, @Field("page") page: Int): Call<GetTopicResponse>

    @FormUrlEncoded
    @POST("getCategoriesPrograms.php")
    fun loadCategoriesAdnPrograms(@Field("access_token") accessToken: String, @Field("page") page: Int): Call<GetCategoriesAndProgramsResponse>


}
