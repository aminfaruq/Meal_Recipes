package co.id.aminfaruq.core.domain.usecase

import androidx.lifecycle.LiveData
import co.id.aminfaruq.core.domain.model.DetailMeal
import co.id.aminfaruq.core.domain.repository.FavoriteRepository

class FavoriteInteractor(private val favoriteRepository: FavoriteRepository) : FavoriteUseCase {
    override fun getFavoriteMeals(): LiveData<List<DetailMeal>> =
        favoriteRepository.getFavoriteMeals()
}