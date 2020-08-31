package co.id.aminfaruq.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ResponseSearch(

	@field:SerializedName("meals")
	val meals: List<SearchItem>
)

data class SearchItem(

	@field:SerializedName("strIngredient10")
	val strIngredient10: String? = null,

	@field:SerializedName("strIngredient12")
	val strIngredient12: String? = null,

	@field:SerializedName("strIngredient11")
	val strIngredient11: String? = null,

	@field:SerializedName("strIngredient14")
	val strIngredient14: String? = null,

	@field:SerializedName("strCategory")
	val strCategory: String? = null,

	@field:SerializedName("strIngredient13")
	val strIngredient13: String? = null,

	@field:SerializedName("strIngredient16")
	val strIngredient16: String? = null,

	@field:SerializedName("strIngredient15")
	val strIngredient15: String? = null,

	@field:SerializedName("strIngredient18")
	val strIngredient18: String? = null,

	@field:SerializedName("strIngredient17")
	val strIngredient17: String? = null,

	@field:SerializedName("strArea")
	val strArea: String? = null,

	@field:SerializedName("strIngredient19")
	val strIngredient19: String? = null,

	@field:SerializedName("idMeal")
	val idMeal: String? = null,

	@field:SerializedName("strInstructions")
	val strInstructions: String? = null,

	@field:SerializedName("strIngredient1")
	val strIngredient1: String? = null,

	@field:SerializedName("strIngredient3")
	val strIngredient3: String? = null,

	@field:SerializedName("strIngredient2")
	val strIngredient2: String? = null,

	@field:SerializedName("strIngredient20")
	val strIngredient20: String? = null,

	@field:SerializedName("strIngredient5")
	val strIngredient5: String? = null,

	@field:SerializedName("strIngredient4")
	val strIngredient4: String? = null,

	@field:SerializedName("strIngredient7")
	val strIngredient7: String? = null,

	@field:SerializedName("strIngredient6")
	val strIngredient6: String? = null,

	@field:SerializedName("strIngredient9")
	val strIngredient9: String? = null,

	@field:SerializedName("strIngredient8")
	val strIngredient8: String? = null,

	@field:SerializedName("strMealThumb")
	val strMealThumb: String? = null,

	@field:SerializedName("strMeasure20")
	val strMeasure20: String? = null,

	@field:SerializedName("strYoutube")
	val strYoutube: String? = null,

	@field:SerializedName("strMeal")
	val strMeal: String? = null,

	@field:SerializedName("strMeasure12")
	val strMeasure12: String? = null,

	@field:SerializedName("strMeasure13")
	val strMeasure13: String? = null,

	@field:SerializedName("strMeasure10")
	val strMeasure10: String? = null,

	@field:SerializedName("strMeasure11")
	val strMeasure11: String? = null,

	@field:SerializedName("strSource")
	val strSource: String? = null,

	@field:SerializedName("strMeasure9")
	val strMeasure9: String? = null,

	@field:SerializedName("strMeasure7")
	val strMeasure7: String? = null,

	@field:SerializedName("strMeasure8")
	val strMeasure8: String? = null,

	@field:SerializedName("strMeasure5")
	val strMeasure5: String? = null,

	@field:SerializedName("strMeasure6")
	val strMeasure6: String? = null,

	@field:SerializedName("strMeasure3")
	val strMeasure3: String? = null,

	@field:SerializedName("strMeasure4")
	val strMeasure4: String? = null,

	@field:SerializedName("strMeasure1")
	val strMeasure1: String? = null,

	@field:SerializedName("strMeasure18")
	val strMeasure18: String? = null,

	@field:SerializedName("strMeasure2")
	val strMeasure2: String? = null,

	@field:SerializedName("strMeasure19")
	val strMeasure19: String? = null,

	@field:SerializedName("strMeasure16")
	val strMeasure16: String? = null,

	@field:SerializedName("strMeasure17")
	val strMeasure17: String? = null,

	@field:SerializedName("strMeasure14")
	val strMeasure14: String? = null,

	@field:SerializedName("strMeasure15")
	val strMeasure15: String? = null
)
