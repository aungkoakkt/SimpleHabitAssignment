package com.me.simplehabit.data.vos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

import com.google.gson.annotations.SerializedName

@Entity(tableName = "category_program", indices = [Index(value = ["category_id"], unique = true)])
data class CategoriesProgramVO(

        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "category_program_id")
        val categoryProgramId: Int,

        @ColumnInfo(name = "category_id")
        @SerializedName("category-id")
        val categoryId: String,

        @ColumnInfo(name = "title")
        @SerializedName("title")
        val title: String,

        @ColumnInfo(name = "program_list")
        @SerializedName("programs")
        val programs: List<ProgramVO>

)
