package co.id.aminfaruq.core.domain.usecase

import co.id.aminfaruq.core.data.source.local.entity.DetailMealEntity
import co.id.aminfaruq.core.domain.model.DetailMeal
import io.reactivex.Single

interface DetailMealUseCase {

    fun getDetailMeal(id: Int): Single<List<DetailMeal>>

    fun saveMeals(meals : DetailMeal)

    fun checkMeals(id : String) :  Single<List<DetailMealEntity>>

    fun removeMeals(id : String)

    fun mappingToObject(result : List<DetailMealEntity>) : List<DetailMeal>

}