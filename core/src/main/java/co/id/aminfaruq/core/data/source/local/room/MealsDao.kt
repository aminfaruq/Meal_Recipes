package co.id.aminfaruq.core.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import co.id.aminfaruq.core.data.source.local.entity.DetailMealEntity
import io.reactivex.Single

@Dao
interface MealsDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMeal(meal: DetailMealEntity)

    @Query("DELETE from detailMeal where idMeal=:id ")
    fun removeMeals(id: String)

    @Query("SELECT * FROM detailMeal WHERE idMeal=:idMeals")
    fun  getFavMealsById(idMeals: String) : Single<List<DetailMealEntity>>

    @Query("SELECT * FROM detailMeal ORDER BY idMeal ASC")
    fun getFavMeals() : LiveData<List<DetailMealEntity>>
}