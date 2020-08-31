package co.id.aminfaruq.core.domain.usecase

import co.id.aminfaruq.core.domain.model.Meals
import io.reactivex.Single

interface MealsUseCase {

    fun getMeals(categories: String): Single<List<Meals>>

}