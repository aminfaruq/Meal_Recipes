package co.id.aminfaruq.core.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Meals (
    val strMealThumb: String,
    val idMeal: String,
    val strMeal: String
) : Parcelable