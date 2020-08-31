package co.id.aminfaruq.core.domain.repository

import co.id.aminfaruq.core.domain.model.Categories
import io.reactivex.Single

interface CategoriesRepository {

    fun getCategories() : Single<List<Categories>>
}