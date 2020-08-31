package co.id.aminfaruq.core.data.repository

import co.id.aminfaruq.core.data.mapper.response.ItemCategoriesMapper
import co.id.aminfaruq.core.data.source.remote.network.ApiService
import co.id.aminfaruq.core.domain.model.Categories
import co.id.aminfaruq.core.domain.repository.CategoriesRepository
import io.reactivex.Single

class CategoriesRepositoryImpl(
    private val apiService: ApiService,
    private val itemCategoriesMapper: ItemCategoriesMapper
) : CategoriesRepository {
    override fun getCategories(): Single<List<Categories>> {
        return apiService.getCategories().map {
           itemCategoriesMapper.mapToListDomain(it.categories)
        }
    }
}