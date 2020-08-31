package co.id.aminfaruq.core.domain.repository

import androidx.lifecycle.LiveData
import co.id.aminfaruq.core.domain.model.DetailMeal

interface FavoriteRepository {

    fun getFavoriteMeals() : LiveData<List<DetailMeal>>
}