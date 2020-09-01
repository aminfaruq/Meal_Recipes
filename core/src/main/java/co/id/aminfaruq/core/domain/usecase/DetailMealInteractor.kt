package co.id.aminfaruq.core.domain.usecase

import co.id.aminfaruq.core.data.source.local.entity.DetailMealEntity
import co.id.aminfaruq.core.domain.model.DetailMeal
import co.id.aminfaruq.core.domain.repository.DetailMealRepository

class DetailMealInteractor(private val detailMealRepository: DetailMealRepository) :
    DetailMealUseCase {

    override fun getDetailMeal(id: Int) = detailMealRepository.getDetailMeal(id)

    override fun saveMeals(meals: DetailMeal) = detailMealRepository.saveMeals(meals)

    override fun checkMeals(id: String) = detailMealRepository.checkMeals(id)

    override fun removeMeals(id: String) = detailMealRepository.removeMeals(id)

    override fun mappingToObject(result: List<DetailMealEntity>) =
        detailMealRepository.mappingToObject(result)

}