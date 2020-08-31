package co.id.aminfaruq.core.domain.repository

import co.id.aminfaruq.core.domain.model.Search
import io.reactivex.Single

interface SearchRepository {

    fun getSearchMeals(meals: String): Single<List<Search>>

}