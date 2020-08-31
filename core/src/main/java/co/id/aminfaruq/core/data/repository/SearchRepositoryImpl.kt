package co.id.aminfaruq.core.data.repository

import co.id.aminfaruq.core.data.mapper.response.ItemSearchMapper
import co.id.aminfaruq.core.data.source.remote.network.ApiService
import co.id.aminfaruq.core.domain.model.Search
import co.id.aminfaruq.core.domain.repository.SearchRepository
import io.reactivex.Single

class SearchRepositoryImpl(
    private val apiService: ApiService,
    private val itemSearchMapper: ItemSearchMapper
) : SearchRepository {
    override fun getSearchMeals(meals: String): Single<List<Search>> {
        return apiService.searchMeal(meals).map {
            itemSearchMapper.mapToListDomain(it.meals)
        }
    }
}