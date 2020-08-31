package co.id.aminfaruq.mealrecipes.ui.meals

import androidx.lifecycle.MutableLiveData
import co.id.aminfaruq.core.domain.model.Meals
import co.id.aminfaruq.core.domain.usecase.MealsUseCase
import co.id.aminfaruq.core.ui.BaseViewModel
import co.id.aminfaruq.core.utils.RxUtils

class MealsVM(private val mealsUseCase: MealsUseCase) : BaseViewModel() {

    val postsData = MutableLiveData<List<Meals>>()
    val showProgressbar = MutableLiveData<Boolean>()
    val messageData = MutableLiveData<String>()

    fun getMeals(categories: String) {
        showProgressbar.value = true
        compositeDisposable.add(
            mealsUseCase.getMeals(categories)
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