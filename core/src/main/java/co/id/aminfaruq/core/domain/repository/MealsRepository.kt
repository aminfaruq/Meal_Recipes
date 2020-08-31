package co.id.aminfaruq.core.domain.repository

import co.id.aminfaruq.core.domain.model.Meals
import io.reactivex.Single

interface MealsRepository {

    fun getMeals(categories: String): Single<List<Meals>>

}