package co.id.aminfaruq.core.domain.usecase

import co.id.aminfaruq.core.domain.repository.CategoriesRepository

class CategoriesInteractor(private val categoriesRepository: CategoriesRepository) : CategoriesUseCase{
    override fun getCategories() = categoriesRepository.getCategories()
}