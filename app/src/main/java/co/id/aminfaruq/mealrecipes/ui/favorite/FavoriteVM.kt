package co.id.aminfaruq.mealrecipes.ui.favorite

import androidx.lifecycle.ViewModel
import co.id.aminfaruq.core.domain.usecase.FavoriteUseCase

class FavoriteVM(favoriteUseCase: FavoriteUseCase) : ViewModel() {

    val getFavoriteMeals = favoriteUseCase.getFavoriteMeals()
}