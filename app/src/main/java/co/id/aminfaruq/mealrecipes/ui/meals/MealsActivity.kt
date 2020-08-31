package co.id.aminfaruq.mealrecipes.ui.meals

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import co.id.aminfaruq.core.domain.model.Categories
import co.id.aminfaruq.core.domain.model.Meals
import co.id.aminfaruq.core.ui.MealsAdapter
import co.id.aminfaruq.core.utils.isNetworkAvailable
import co.id.aminfaruq.mealrecipes.R
import co.id.aminfaruq.mealrecipes.ui.detail.DetailMealActivity
import co.id.aminfaruq.mealrecipes.ui.favorite.FavoriteActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_meals.*
import kotlinx.android.synthetic.main.categories_main.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.android.ext.android.inject

class MealsActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_CATEGORY = "category"
    }

    private val mealsVM: MealsVM by inject()

    @ExperimentalCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meals)
        val category = intent.getParcelableExtra<Categories>(EXTRA_CATEGORY)
        Glide.with(this)
            .load(category?.strCategoryThumb)
            .into(iv_image_desc)
        tv_description.text = category?.strCategoryDescription

        if (isNetworkAvailable()) {
            category?.strCategory?.let { mealsVM.getMeals(it) }
        } else {
            Toast.makeText(
                this,
                getString(R.string.no_internet_connection),
                Toast.LENGTH_SHORT
            ).show()
        }


        val mealsAdapter = MealsAdapter(object : MealsAdapter.OnItemClick{
            override fun onClick(item: Meals) {
                val intent = Intent(this@MealsActivity, DetailMealActivity::class.java)
                intent.putExtra(DetailMealActivity.EXTRA_MEAL, item.idMeal)
                startActivity(intent)
            }
        })

        mealsVM.postsData.observe(this, Observer {
            with(mealsVM) {
                postsData.observe(this@MealsActivity, Observer {
                    mealsAdapter.setData(it)
                })

                messageData.observe(this@MealsActivity, Observer {
                    Toast.makeText(this@MealsActivity, it, Toast.LENGTH_SHORT).show()
                })

                showProgressbar.observe(this@MealsActivity, Observer { isVisible ->
                    pb_meals.visibility = if (isVisible) View.VISIBLE else View.GONE
                })
            }
        })

        with(rv_meals) {
            layoutManager =
                GridLayoutManager(this@MealsActivity, 2, GridLayoutManager.VERTICAL, false)
            overScrollMode = View.OVER_SCROLL_NEVER
            setHasFixedSize(true)
            adapter = mealsAdapter
        }


    }


}