package co.id.aminfaruq.core.di

import androidx.room.Room
import co.id.aminfaruq.core.data.mapper.entity.ItemDetailEntityMapper
import co.id.aminfaruq.core.data.mapper.response.ItemCategoriesMapper
import co.id.aminfaruq.core.data.mapper.response.ItemDetailMapper
import co.id.aminfaruq.core.data.mapper.response.ItemMealsMapper
import co.id.aminfaruq.core.data.mapper.response.ItemSearchMapper
import co.id.aminfaruq.core.data.repository.*
import co.id.aminfaruq.core.data.source.local.room.MealsDatabase
import co.id.aminfaruq.core.data.source.remote.network.ApiService
import co.id.aminfaruq.core.domain.repository.*
import co.id.aminfaruq.core.utils.AppExecutors
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

val databaseModule = module {
    single { getExecutor() }
    factory { get<MealsDatabase>().mealsDao() }
    single {
        Room.databaseBuilder(
            androidContext(),
            MealsDatabase::class.java, "Meals.db"
        ).fallbackToDestructiveMigration().build()
    }
}

val networkModule = module {
    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build()
    }
    single {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(get())
            .build()
        retrofit.create(ApiService::class.java)
    }
}

fun getExecutor(): Executor {
    return Executors.newFixedThreadPool(2)
}

val repositoryModule = module {
    factory { AppExecutors() }
    single {
        CategoriesRepositoryImpl(
            get(),
            get()
        ) as CategoriesRepository
    }

    single {
        MealsRepositoryImpl(
            get(),
            get()
        ) as MealsRepository
    }

    single {
        DetailMealRepositoryImpl(
            get(),
            get(),
            get(),
            get(),
            get()
        ) as DetailMealRepository
    }

    single {
        FavoriteMealRepositoryImpl(
            get(),
            get()
        ) as FavoriteRepository
    }

    single {
        SearchRepositoryImpl(
            get(),
            get()
        ) as SearchRepository
    }


}

val mapperModule = module {
    single { ItemCategoriesMapper() }
    single { ItemMealsMapper() }
    single { ItemDetailMapper() }
    single { ItemSearchMapper() }
    //Local
    single { ItemDetailEntityMapper() }
}

