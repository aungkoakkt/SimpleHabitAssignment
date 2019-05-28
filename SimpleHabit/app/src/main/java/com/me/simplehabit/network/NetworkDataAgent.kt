package com.me.simplehabit.network

import com.me.simplehabit.delegates.CategoryProgramDelegate
import com.me.simplehabit.delegates.CurrentProgramResponseDelegate
import com.me.simplehabit.delegates.TopicResponseDelegate
import com.me.simplehabit.network.responses.GetCategoriesAndProgramsResponse
import com.me.simplehabit.network.responses.GetCurrentProgramResponse
import com.me.simplehabit.network.responses.GetTopicResponse
import com.me.simplehabit.utils.CommonInstances

import java.util.concurrent.TimeUnit

import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkDataAgent private constructor() : SimpleHabitDataAgent {

    private val theApi: SimpleHabitAPI

    init {

        val okHttpClient = OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build()

        val retrofit = Retrofit.Builder()
                .baseUrl("http://padcmyanmar.com/padc-5/simple-habits/")
                .addConverterFactory(GsonConverterFactory.create(CommonInstances.gsonInstance))
                .client(okHttpClient)
                .build()

        theApi = retrofit.create(SimpleHabitAPI::class.java)

    }


    override fun getCurrentProgram(token: String, page: Int, delegate: CurrentProgramResponseDelegate) {

        theApi.loadCurrentProgram(token, page).enqueue(object : Callback<GetCurrentProgramResponse> {
            override fun onResponse(call: Call<GetCurrentProgramResponse>, response: Response<GetCurrentProgramResponse>) {
                val currentProgramResponse = response.body()

                if (currentProgramResponse != null) {

                    if (currentProgramResponse.isResponseSuccess) {
                        delegate.onSuccess(currentProgramResponse.currentProgram!!)
                    } else {
                        delegate.onFail(currentProgramResponse.message!!)
                    }
                } else {
                    delegate.onFail("Current Program Response is null")
                }
            }

            override fun onFailure(call: Call<GetCurrentProgramResponse>, t: Throwable) {
                delegate.onFail(t.message!!)
            }
        })
    }

    override fun getTopics(token: String, page: Int, delegate: TopicResponseDelegate) {

        theApi.loadTopics(token, page).enqueue(object : Callback<GetTopicResponse> {
            override fun onResponse(call: Call<GetTopicResponse>, response: Response<GetTopicResponse>) {
                val topicResponse = response.body()

                if (topicResponse != null) {

                    if (topicResponse.isResponseSuccess) {
                        delegate.onSuccess(topicResponse.topics!!)
                    } else {
                        delegate.onFail(topicResponse.message!!)
                    }
                } else {
                    delegate.onFail("Current Program Response is null")
                }
            }

            override fun onFailure(call: Call<GetTopicResponse>, t: Throwable) {
                delegate.onFail(t.message!!)
            }
        })
    }

    override fun getCategoriesAndPrograms(token: String, page: Int, delegate: CategoryProgramDelegate) {

        theApi.loadCategoriesAdnPrograms(token, page).enqueue(object : Callback<GetCategoriesAndProgramsResponse> {
            override fun onResponse(call: Call<GetCategoriesAndProgramsResponse>, response: Response<GetCategoriesAndProgramsResponse>) {
                val categoriesAndProgramsResponse = response.body()

                if (categoriesAndProgramsResponse != null) {
                    if (categoriesAndProgramsResponse.isResponseSuccess) {
                        delegate.onSuccess(categoriesAndProgramsResponse.categoriesPrograms!!)
                    } else {
                        delegate.onFail(categoriesAndProgramsResponse.message!!)
                    }
                } else {
                    delegate.onFail("Category and Program is null")
                }
            }

            override fun onFailure(call: Call<GetCategoriesAndProgramsResponse>, t: Throwable) {

            }
        })
    }

    companion object {

        private var INSTANCE: NetworkDataAgent? = null
        fun getInstance(): NetworkDataAgent {
            if (INSTANCE == null) {
                INSTANCE = NetworkDataAgent()
            }

            val i = INSTANCE
            return i!!
        }
    }
}
