package co.id.aminfaruq.core.domain.usecase

import co.id.aminfaruq.core.domain.repository.MealsRepository

class MealsInteractor(private val mealsRepository: MealsRepository) : MealsUseCase {
    override fun getMeals(categories: String) = mealsRepository.getMeals(categories)
}