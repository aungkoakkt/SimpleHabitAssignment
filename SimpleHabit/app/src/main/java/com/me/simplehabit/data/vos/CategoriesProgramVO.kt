package com.me.simplehabit.data.vos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

import com.google.gson.annotations.SerializedName

@Entity(tableName = "category_program", indices = [Index(value = ["category_id"], unique = true)])
class CategoriesProgramVO {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "category_program_id")
    var categoryProgramId: Int = 0

    @ColumnInfo(name = "category_id")
    @SerializedName("category-id")
    var categoryId: String? = null

    @ColumnInfo(name = "title")
    @SerializedName("title")
    var title: String? = null

    @ColumnInfo(name = "program_list")
    @SerializedName("programs")
    var programs: List<ProgramVO>? = null

}
