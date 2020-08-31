package co.id.aminfaruq.mealrecipes.ui.detail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import co.id.aminfaruq.core.domain.model.DetailMeal
import co.id.aminfaruq.core.utils.isNetworkAvailable
import co.id.aminfaruq.mealrecipes.R
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail_meal.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.android.viewmodel.ext.android.viewModel


class DetailMealActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        const val EXTRA_MEAL = "meal"
    }

    private val detailMealVM: DetailMealVM by viewModel()
    private var dataMeal: DetailMeal? = null
    private var idMeals: String? = null


    @ExperimentalCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_meal)
        setupActionBar()

        idMeals = intent.getStringExtra(EXTRA_MEAL)

        if (isNetworkAvailable()) {
            if (idMeals != null) {
                idMeals?.toInt()?.let { detailMealVM.getDetailMeal(it) }
            }
        } else {
            Toast.makeText(
                this,
                "No Internet Connection",
                Toast.LENGTH_SHORT
            ).show()
        }
        updateUI()
        favLoveFragmentDetailIB.setOnClickListener(this)
        detailMealVM.checkFavMeals(idMeals.toString())
    }


    private fun updateUI() {
        with(detailMealVM) {
            postsData.observe(this@DetailMealActivity, Observer { meals ->
                Glide.with(this@DetailMealActivity)
                    .load(meals[0].strMealThumb)
                    .into(mealThumb)
                collapsing_toolbar.title = meals[0].strMeal
                category.text = meals[0].strCategory
                country.text = meals[0].strArea
                instructions.text = meals[0].strInstructions
                dataMeal = meals[0]

                if (meals[0].strIngredient1?.isNotEmpty() == true) {
                    ingredient.append("\n \u2022 " + meals[0].strIngredient1)
                }
                if (meals[0].strIngredient2?.isNotEmpty() == true) {
                    ingredient.append("\n \u2022 " + meals[0].strIngredient2)
                }
                if (meals[0].strIngredient3?.isNotEmpty() == true) {
                    ingredient.append("\n \u2022 " + meals[0].strIngredient3)
                }
                if (meals[0].strIngredient4?.isNotEmpty() == true) {
                    ingredient.append("\n \u2022 " + meals[0].strIngredient4)
                }
                if (meals[0].strIngredient5?.isNotEmpty() == true) {
                    ingredient.append("\n \u2022 " + meals[0].strIngredient5)
                }
                if (meals[0].strIngredient6?.isNotEmpty() == true) {
                    ingredient.append("\n \u2022 " + meals[0].strIngredient6)
                }
                if (meals[0].strIngredient7?.isNotEmpty() == true) {
                    ingredient.append("\n \u2022 " + meals[0].strIngredient7)
                }
                if (meals[0].strIngredient8?.isNotEmpty() == true) {
                    ingredient.append("\n \u2022 " + meals[0].strIngredient8)
                }
                if (meals[0].strIngredient9?.isNotEmpty() == true) {
                    ingredient.append("\n \u2022 " + meals[0].strIngredient9)
                }
                if (meals[0].strIngredient10?.isNotEmpty() == true) {
                    ingredient.append("\n \u2022 " + meals[0].strIngredient10)
                }
                if (meals[0].strIngredient11?.isNotEmpty() == true) {
                    ingredient.append("\n \u2022 " + meals[0].strIngredient11)
                }
                if (meals[0].strIngredient12?.isNotEmpty() == true) {
                    ingredient.append("\n \u2022 " + meals[0].strIngredient12)
                }
                if (meals[0].strIngredient13?.isNotEmpty() == true) {
                    ingredient.append("\n \u2022 " + meals[0].strIngredient13)
                }
                if (meals[0].strIngredient14?.isNotEmpty() == true) {
                    ingredient.append("\n \u2022 " + meals[0].strIngredient14)
                }
                if (meals[0].strIngredient15?.isNotEmpty() == true) {
                    ingredient.append("\n \u2022 " + meals[0].strIngredient15)
                }
                if (meals[0].strIngredient16?.isNotEmpty() == true) {
                    ingredient.append("\n \u2022 " + meals[0].strIngredient16)
                }
                if (meals[0].strIngredient17?.isNotEmpty() == true) {
                    ingredient.append("\n \u2022 " + meals[0].strIngredient17)
                }
                if (meals[0].strIngredient18?.isNotEmpty() == true) {
                    ingredient.append("\n \u2022 " + meals[0].strIngredient18)
                }
                if (meals[0].strIngredient19?.isNotEmpty() == true) {
                    ingredient.append("\n \u2022 " + meals[0].strIngredient19)
                }
                if (meals[0].strIngredient20?.isNotEmpty() == true) {
                    ingredient.append("\n \u2022 " + meals[0].strIngredient20)
                }

                if (meals[0].strMeasure1?.isNotEmpty() == true && !Character.isWhitespace(meals[0].strMeasure1!![0])) {
                    measure.append("\n : " + meals[0].strMeasure1)
                }
                if (meals[0].strMeasure2?.isNotEmpty() == true && !Character.isWhitespace(meals[0].strMeasure2!![0])) {
                    measure.append("\n : " + meals[0].strMeasure2)
                }
                if (meals[0].strMeasure3?.isNotEmpty() == true && !Character.isWhitespace(meals[0].strMeasure3!![0])) {
                    measure.append("\n : " + meals[0].strMeasure3)
                }
                if (meals[0].strMeasure4?.isNotEmpty() == true && !Character.isWhitespace(
                        meals[0].strMeasure4?.get(
                            0
                        )!!
                    )
                ) {
                    measure.append("\n : " + meals[0].strMeasure4)
                }
                if (meals[0].strMeasure5?.isNotEmpty() == true && !Character.isWhitespace(meals[0].strMeasure5!![0])) {
                    measure.append("\n : " + meals[0].strMeasure5)
                }
                if (meals[0].strMeasure6?.isNotEmpty() == true && !Character.isWhitespace(meals[0].strMeasure6!![0])) {
                    measure.append("\n : " + meals[0].strMeasure6)
                }
                if (meals[0].strMeasure7?.isNotEmpty() == true && !Character.isWhitespace(meals[0].strMeasure7!![0])) {
                    measure.append("\n : " + meals[0].strMeasure7)
                }
                if (meals[0].strMeasure8?.isNotEmpty() == true && !Character.isWhitespace(meals[0].strMeasure8!![0])) {
                    measure.append("\n : " + meals[0].strMeasure8)
                }
                if (meals[0].strMeasure9?.isNotEmpty() == true && !Character.isWhitespace(meals[0].strMeasure9!![0])) {
                    measure.append("\n : " + meals[0].strMeasure9)
                }
                if (meals[0].strMeasure10?.isNotEmpty() == true && !Character.isWhitespace(meals[0].strMeasure10!![0])) {
                    measure.append("\n : " + meals[0].strMeasure10)
                }
                if (meals[0].strMeasure11?.isNotEmpty() == true && !Character.isWhitespace(
                        meals[0].strMeasure11?.get(
                            0
                        )!!
                    )
                ) {
                    measure.append("\n : " + meals[0].strMeasure11)
                }
                if (meals[0].strMeasure12?.isNotEmpty() == true && !Character.isWhitespace(meals[0].strMeasure12!![0])) {
                    measure.append("\n : " + meals[0].strMeasure12)
                }
                if (meals[0].strMeasure13?.isNotEmpty() == true && !Character.isWhitespace(meals[0].strMeasure13!![0])) {
                    measure.append("\n : " + meals[0].strMeasure13)
                }
                if (meals[0].strMeasure14?.isNotEmpty() == true && !Character.isWhitespace(meals[0].strMeasure14!![0])) {
                    measure.append("\n : " + meals[0].strMeasure14)
                }
                if (meals[0].strMeasure15?.isNotEmpty() == true && !Character.isWhitespace(meals[0].strMeasure15!![0])) {
                    measure.append("\n : " + meals[0].strMeasure15)
                }
                if (meals[0].strMeasure16?.isNotEmpty() == true && !Character.isWhitespace(meals[0].strMeasure16!![0])) {
                    measure.append("\n : " + meals[0].strMeasure16)
                }
                if (meals[0].strMeasure17?.isNotEmpty() == true && !Character.isWhitespace(meals[0].strMeasure17!![0])) {
                    measure.append("\n : " + meals[0].strMeasure17)
                }
                if (meals[0].strMeasure18?.isNotEmpty() == true && !Character.isWhitespace(meals[0].strMeasure18!![0])) {
                    measure.append("\n : " + meals[0].strMeasure18)
                }
                if (meals[0].strMeasure19?.isNotEmpty() == true && !Character.isWhitespace(meals[0].strMeasure19!![0])) {
                    measure.append("\n : " + meals[0].strMeasure19)
                }
                if (meals[0].strMeasure20?.isNotEmpty() == true && !Character.isWhitespace(meals[0].strMeasure20!![0])) {
                    measure.append("\n : " + meals[0].strMeasure20)
                }

                youtube.setOnClickListener {
                    val intentYoutube = Intent(Intent.ACTION_VIEW)
                    intentYoutube.data = Uri.parse(meals[0].strYoutube)
                    startActivity(intentYoutube)
                }

                source.setOnClickListener {
                    val intentSource = Intent(Intent.ACTION_VIEW)
                    intentSource.data = Uri.parse(meals[0].strSource)
                    startActivity(intentSource)
                }


            })

            messageData.observe(this@DetailMealActivity, Observer {
                Toast.makeText(
                    this@DetailMealActivity,
                    it,
                    Toast.LENGTH_SHORT
                ).show()
                Log.d("Detail", it)
            })

            showProgressbar.observe(this@DetailMealActivity, Observer { isVisible ->
                progressBar.visibility = if (isVisible) View.VISIBLE else View.GONE
            })



            saveData.observe(this@DetailMealActivity, Observer {
                favLoveFragmentDetailIB.background = ContextCompat.getDrawable(
                    this@DetailMealActivity,
                    R.drawable.ic_favorite
                )
                Toast.makeText(
                    this@DetailMealActivity,
                    "Disimpan",
                    Toast.LENGTH_SHORT
                ).show()
            })

            removeData.observe(this@DetailMealActivity, Observer {
                favLoveFragmentDetailIB.background = ContextCompat.getDrawable(
                    this@DetailMealActivity,
                    R.drawable.ic_favorite_border
                )
                Toast.makeText(
                    this@DetailMealActivity,
                    "Dihapus",
                    Toast.LENGTH_SHORT
                ).show()
            })

            favMealDataFound.observe(this@DetailMealActivity, Observer { meals ->
                meals.map {
                    if (it.idMeal == idMeals) {
                        favLoveFragmentDetailIB.background = ContextCompat.getDrawable(
                            this@DetailMealActivity,
                            R.drawable.ic_favorite
                        )
                    }
                }

            })
        }
    }


    private fun setupActionBar() {
        setSupportActionBar(toolbar)
        collapsing_toolbar.setContentScrimColor(resources.getColor(android.R.color.white))
        collapsing_toolbar.setCollapsedTitleTextColor(resources.getColor(R.color.colorPrimary))
        collapsing_toolbar.setExpandedTitleColor(resources.getColor(android.R.color.white))
        if (supportActionBar != null) {
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        }
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.favLoveFragmentDetailIB -> {
                if (favLoveFragmentDetailIB.background.constantState == ContextCompat.getDrawable(
                        this,
                        R.drawable.ic_favorite_border
                    )!!.constantState
                ) {
                    dataMeal?.let { detailMealVM.saveFavMeals(it) }
                } else {
                    dataMeal?.idMeal?.let { detailMealVM.removeMeals(it) }
                }
            }
        }
    }


}