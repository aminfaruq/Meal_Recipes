package co.id.aminfaruq.core.data.repository

import co.id.aminfaruq.core.data.mapper.response.ItemMealsMapper
import co.id.aminfaruq.core.data.source.remote.network.ApiService
import co.id.aminfaruq.core.domain.model.Meals
import co.id.aminfaruq.core.domain.repository.MealsRepository
import io.reactivex.Single

class MealsRepositoryImpl(
    private val apiService: ApiService,
    private val itemMealsMapper: ItemMealsMapper
) : MealsRepository {
    override fun getMeals(categories: String): Single<List<Meals>> {
        return apiService.getMealsByCategories(categories).map {
            itemMealsMapper.mapToListDomain(it.meals)
        }
    }
}
