package co.id.aminfaruq.mealrecipes.search.ui

import androidx.lifecycle.MutableLiveData
import co.id.aminfaruq.core.domain.model.Search
import co.id.aminfaruq.core.domain.usecase.SearchUseCase
import co.id.aminfaruq.core.ui.BaseViewModel
import co.id.aminfaruq.core.utils.RxUtils

class SearchVM(private val searchUseCase: SearchUseCase) : BaseViewModel() {

    val postsData = MutableLiveData<List<Search>>()
    val showProgressbar = MutableLiveData<Boolean>()
    val messageData = MutableLiveData<String>()

    fun getMeals(meals: String) {
        showProgressbar.value = true
        compositeDisposable.add(
            searchUseCase.getSearchMeals(meals)
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