package co.id.aminfaruq.mealrecipes.ui.categories

import androidx.lifecycle.MutableLiveData
import co.id.aminfaruq.core.domain.model.Categories
import co.id.aminfaruq.core.domain.usecase.CategoriesUseCase
import co.id.aminfaruq.core.ui.BaseViewModel
import co.id.aminfaruq.core.utils.RxUtils

class CategoriesVM(
    private val categoriesUseCase: CategoriesUseCase
) : BaseViewModel() {

    val postsData = MutableLiveData<List<Categories>>()
    val showProgressbar = MutableLiveData<Boolean>()
    val messageData = MutableLiveData<String>()

    fun getCategories() {
        showProgressbar.value = true
        compositeDisposable.add(
            categoriesUseCase.getCategories()
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