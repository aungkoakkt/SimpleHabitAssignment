package com.me.simplehabit.network.responses

import com.google.gson.annotations.SerializedName
import com.me.simplehabit.data.vos.CategoriesProgramVO

data class GetCategoriesAndProgramsResponse(

        @SerializedName("page")
        val page: String,

        @SerializedName("categoriesPrograms")
        val categoriesPrograms: List<CategoriesProgramVO>

) : BaseResponse()
