package co.id.aminfaruq.mealrecipes.ui.favorite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import co.id.aminfaruq.core.domain.model.DetailMeal
import co.id.aminfaruq.core.ui.FavoriteAdapter
import co.id.aminfaruq.mealrecipes.R
import co.id.aminfaruq.mealrecipes.ui.detail.DetailMealActivity
import kotlinx.android.synthetic.main.activity_favorite.*
import kotlinx.android.synthetic.main.activity_meals.*
import org.koin.android.ext.android.inject

class FavoriteActivity : AppCompatActivity() {

    private val favoriteVM: FavoriteVM by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite)

        val favoriteAdapter = FavoriteAdapter(object : FavoriteAdapter.OnItemClick{
            override fun onClick(item: DetailMeal) {
                val intent = Intent(this@FavoriteActivity, DetailMealActivity::class.java)
                intent.putExtra(DetailMealActivity.EXTRA_MEAL, item.idMeal)
                startActivity(intent)
            }
        })


        favoriteVM.getFavoriteMeals.observe(this , Observer {
            favoriteAdapter.setData(it)
        })

        with(rv_favorite) {
            layoutManager =
                GridLayoutManager(this@FavoriteActivity, 2, GridLayoutManager.VERTICAL, false)
            overScrollMode = View.OVER_SCROLL_NEVER
            setHasFixedSize(true)
            adapter = favoriteAdapter
            setEmptyView(imageView)
        }
    }
}