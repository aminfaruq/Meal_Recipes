package co.id.aminfaruq.mealrecipes.di

import co.id.aminfaruq.core.domain.usecase.*
import co.id.aminfaruq.mealrecipes.ui.categories.CategoriesVM
import co.id.aminfaruq.mealrecipes.ui.detail.DetailMealVM
import co.id.aminfaruq.mealrecipes.ui.favorite.FavoriteVM
import co.id.aminfaruq.mealrecipes.ui.meals.MealsVM
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<CategoriesUseCase> { CategoriesInteractor(get()) }
    factory<MealsUseCase> { MealsInteractor(get()) }
    factory<DetailMealUseCase> { DetailMealInteractor(get()) }
    factory<FavoriteUseCase> { FavoriteInteractor(get()) }
    factory<SearchUseCase> { SearchInteractor(get()) }
}

val vieModelModule = module {
    viewModel { CategoriesVM(get()) }
    viewModel { MealsVM(get()) }
    viewModel { DetailMealVM(get()) }
    viewModel { FavoriteVM(get()) }
}