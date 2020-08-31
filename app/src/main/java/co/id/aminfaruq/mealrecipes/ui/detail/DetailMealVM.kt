package co.id.aminfaruq.mealrecipes.ui.detail

import androidx.lifecycle.MutableLiveData
import co.id.aminfaruq.core.data.mapper.entity.ItemDetailEntityMapper
import co.id.aminfaruq.core.data.source.local.room.MealsDao
import co.id.aminfaruq.core.domain.model.DetailMeal
import co.id.aminfaruq.core.domain.usecase.DetailMealUseCase
import co.id.aminfaruq.core.ui.BaseViewModel
import co.id.aminfaruq.core.utils.RxUtils
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.concurrent.Executor

class DetailMealVM(
    private val detailMealUseCase: DetailMealUseCase
) : BaseViewModel() {

    object FavMeals
    object RemoveMeals

    val postsData = MutableLiveData<List<DetailMeal>>()
    val showProgressbar = MutableLiveData<Boolean>()
    val messageData = MutableLiveData<String>()
    val favMealDataFound = MutableLiveData<List<DetailMeal>>()
    val saveData = MutableLiveData<FavMeals>()
    val removeData = MutableLiveData<RemoveMeals>()

    fun saveFavMeals(meals: DetailMeal) {
        detailMealUseCase.saveMeals(meals)
        saveData.value = FavMeals
    }

    fun checkFavMeals(id: String) {
        compositeDisposable.add(
            detailMealUseCase.checkMeals(id)
                .compose(RxUtils.applySingleAsync())
                .subscribe({ result ->
                    if (result.isNotEmpty()) {
                        runBlocking {
                            val mealsEntity = detailMealUseCase.mappingToObject(result)
                            favMealDataFound.value = mealsEntity
                        }
                    }
                }, this::onError)
        )
    }

    fun removeMeals(idMeals: String) {
        detailMealUseCase.removeMeals(idMeals)
        removeData.value = RemoveMeals
    }

    fun getDetailMeal(id: Int) {
        showProgressbar.value = true
        compositeDisposable.add(
            detailMealUseCase.getDetailMeal(id)
                .compose(RxUtils.applySingleAsync())
                .subscribe({ result ->
                    postsData.value = result
                    showProgressbar.value = false
                }, this::onError)
        )
    }

    override fun onError(error: Throwable) {
        messageData.value = error.message
    }
}