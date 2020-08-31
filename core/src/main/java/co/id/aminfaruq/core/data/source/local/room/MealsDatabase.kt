package co.id.aminfaruq.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import co.id.aminfaruq.core.data.source.local.entity.DetailMealEntity

@Database(
    entities = [
        DetailMealEntity::class
    ],
    version = 2,
    exportSchema = false
)
abstract class MealsDatabase : RoomDatabase() {

    abstract fun mealsDao(): MealsDao

}