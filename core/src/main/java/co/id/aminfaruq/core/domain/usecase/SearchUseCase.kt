package co.id.aminfaruq.core.domain.usecase

import co.id.aminfaruq.core.domain.model.Search
import io.reactivex.Single

interface SearchUseCase {

    fun getSearchMeals(meals: String): Single<List<Search>>

}