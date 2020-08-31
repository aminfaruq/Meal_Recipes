package co.id.aminfaruq.core.data.repository

import co.id.aminfaruq.core.data.mapper.entity.ItemDetailEntityMapper
import co.id.aminfaruq.core.data.mapper.response.ItemDetailMapper
import co.id.aminfaruq.core.data.source.local.entity.DetailMealEntity
import co.id.aminfaruq.core.data.source.local.room.MealsDao
import co.id.aminfaruq.core.data.source.remote.network.ApiService
import co.id.aminfaruq.core.domain.model.DetailMeal
import co.id.aminfaruq.core.domain.repository.DetailMealRepository
import io.reactivex.Single
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.concurrent.Executor

class DetailMealRepositoryImpl(
    private val apiService: ApiService,
    private val itemDetailMapper: ItemDetailMapper,
    private val itemDetailEntityMapper: ItemDetailEntityMapper,
    private val mealsDao: MealsDao,
    private val executor: Executor
) : DetailMealRepository {
    override fun getDetailMeal(id: Int): Single<List<DetailMeal>> {
        return apiService.getDetailMeal(id).map {
            itemDetailMapper.mapToListDomain(it.meals)
        }
    }

    override fun saveMeals(meals: DetailMeal) {
        runBlocking {
            val mealsEntity = itemDetailEntityMapper.mapToModel(meals)
            val job = GlobalScope.launch {
                executor.execute { mealsDao.insertMeal(mealsEntity) }
            }
            job.join()
        }
    }

    override fun checkMeals(id: String): Single<List<DetailMealEntity>> {
        return mealsDao.getFavMealsById(id)
    }

    override fun removeMeals(id: String) {
        executor.execute { mealsDao.removeMeals(id) }
    }

    override fun mappingToObject(result: List<DetailMealEntity>) : List<DetailMeal>{
        return itemDetailEntityMapper.mapToListDomain(result)
    }
}
