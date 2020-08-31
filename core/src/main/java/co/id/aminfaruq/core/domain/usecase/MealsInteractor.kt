package co.id.aminfaruq.core.domain.usecase

import co.id.aminfaruq.core.domain.model.Meals
import co.id.aminfaruq.core.domain.repository.MealsRepository
import io.reactivex.Single

class MealsInteractor(private val mealsRepository: MealsRepository) : MealsUseCase {
    override fun getMeals(categories: String) = mealsRepository.getMeals(categories)
}