package co.id.aminfaruq.core.data.source.remote.network

import co.id.aminfaruq.core.data.source.remote.response.ResponseCategory
import co.id.aminfaruq.core.data.source.remote.response.ResponseDetailMeals
import co.id.aminfaruq.core.data.source.remote.response.ResponseMealsByCategory
import co.id.aminfaruq.core.data.source.remote.response.ResponseSearch
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("categories.php")
    fun getCategories(): Single<ResponseCategory>

    @GET("filter.php")
    fun getMealsByCategories(
        @Query("c") query: String
    ): Single<ResponseMealsByCategory>

    @GET("lookup.php")
    fun getDetailMeal(
        @Query("i") id: Int
    ): Single<ResponseDetailMeals>

    @GET("search.php")
    fun searchMeal(
        @Query("s") search : String
    ) : Single<ResponseSearch>
}