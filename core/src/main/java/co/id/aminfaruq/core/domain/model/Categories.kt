package co.id.aminfaruq.core.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Categories(
    val strCategory: String,
    val strCategoryDescription: String,
    val idCategory: String,
    val strCategoryThumb: String
) : Parcelable