package co.id.aminfaruq.core.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import co.id.aminfaruq.core.data.mapper.entity.ItemDetailEntityMapper
import co.id.aminfaruq.core.data.source.local.room.MealsDao
import co.id.aminfaruq.core.domain.model.DetailMeal
import co.id.aminfaruq.core.domain.repository.FavoriteRepository

class FavoriteMealRepositoryImpl(
    private val mealsDao: MealsDao,
    private val itemDetailEntityMapper: ItemDetailEntityMapper
) : FavoriteRepository {

    override fun getFavoriteMeals(): LiveData<List<DetailMeal>> =
        Transformations.map(mealsDao.getFavMeals()) {
            itemDetailEntityMapper.mapToListDomain(it)
        }

}