package co.id.aminfaruq.core.domain.usecase

import co.id.aminfaruq.core.domain.model.Categories
import co.id.aminfaruq.core.domain.model.DetailMeal
import io.reactivex.Single

interface CategoriesUseCase {

    fun getCategories() : Single<List<Categories>>

}