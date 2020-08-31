package co.id.aminfaruq.core.data.mapper.response

import co.id.aminfaruq.core.data.mapper.BaseMapper
import co.id.aminfaruq.core.data.source.remote.response.MealsItem
import co.id.aminfaruq.core.domain.model.Meals

class ItemMealsMapper :
    BaseMapper<MealsItem, Meals> {
    override fun mapToDomain(model: MealsItem): Meals {
        return Meals(
            model.strMealThumb,
            model.idMeal,
            model.strMeal
        )
    }

    override fun mapToModel(domain: Meals): MealsItem {
        return MealsItem(
            domain.strMealThumb,
            domain.idMeal,
            domain.strMeal
        )
    }
}