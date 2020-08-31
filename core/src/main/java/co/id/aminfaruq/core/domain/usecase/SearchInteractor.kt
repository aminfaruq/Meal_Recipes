package co.id.aminfaruq.core.domain.usecase

import co.id.aminfaruq.core.domain.model.Search
import co.id.aminfaruq.core.domain.repository.SearchRepository
import io.reactivex.Single

class SearchInteractor(private val searchRepository: SearchRepository) : SearchUseCase {

    override fun getSearchMeals(meals: String) = searchRepository.getSearchMeals(meals)
}