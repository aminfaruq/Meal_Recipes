package co.id.aminfaruq.mealrecipes.search.di

import co.id.aminfaruq.mealrecipes.search.ui.SearchVM
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val searchModule = module {
    viewModel { SearchVM(get()) }
}