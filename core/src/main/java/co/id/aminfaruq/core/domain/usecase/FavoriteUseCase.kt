package co.id.aminfaruq.core.domain.usecase

import androidx.lifecycle.LiveData
import co.id.aminfaruq.core.domain.model.DetailMeal

interface FavoriteUseCase {

    fun getFavoriteMeals() : LiveData<List<DetailMeal>>

}