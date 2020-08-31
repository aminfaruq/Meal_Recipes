package co.id.aminfaruq.core.data.mapper.response

import co.id.aminfaruq.core.data.mapper.BaseMapper
import co.id.aminfaruq.core.data.source.remote.response.CategoriesItem
import co.id.aminfaruq.core.domain.model.Categories

class ItemCategoriesMapper :
    BaseMapper<CategoriesItem, Categories> {
    override fun mapToDomain(model: CategoriesItem): Categories {
        return Categories(
            model.strCategory,
            model.strCategoryDescription,
            model.idCategory,
            model.strCategoryThumb
        )
    }

    override fun mapToModel(domain: Categories): CategoriesItem {
        return CategoriesItem(
            domain.strCategory,
            domain.strCategoryDescription,
            domain.idCategory,
            domain.strCategoryThumb
        )
    }

}