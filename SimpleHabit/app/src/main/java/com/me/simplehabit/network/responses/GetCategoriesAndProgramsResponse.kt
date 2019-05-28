package com.me.simplehabit.network.responses

import com.google.gson.annotations.SerializedName
import com.me.simplehabit.data.vos.CategoriesProgramVO

class GetCategoriesAndProgramsResponse : BaseResponse() {

    @SerializedName("page")
    var page: String? = null

    @SerializedName("categoriesPrograms")
    var categoriesPrograms: List<CategoriesProgramVO>? = null

}
