package co.id.aminfaruq.mealrecipes.ui.categories

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import co.id.aminfaruq.core.ui.CategoriesAdapter
import co.id.aminfaruq.core.utils.isNetworkAvailable
import co.id.aminfaruq.mealrecipes.R
import co.id.aminfaruq.mealrecipes.ui.favorite.FavoriteActivity
import co.id.aminfaruq.mealrecipes.ui.meals.MealsActivity
import kotlinx.android.synthetic.main.categories_main.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.android.ext.android.inject

class CategoriesActivity : AppCompatActivity() , View.OnClickListener{

    private val categoriesVM: CategoriesVM by inject()

    @ExperimentalCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.categories_main)
        img_to_favorite.setOnClickListener(this)
        img_to_search.setOnClickListener(this)

        if (isNetworkAvailable()) {
            categoriesVM.getCategories()
        } else {
            Toast.makeText(
                this,
                R.string.no_internet_connection,
                Toast.LENGTH_SHORT
            ).show()
        }

        val categoriesAdapter = CategoriesAdapter()
        categoriesAdapter.onItemClick = { selectedData ->
            val intent = Intent(this, MealsActivity::class.java)
            intent.putExtra(MealsActivity.EXTRA_CATEGORY, selectedData)
            startActivity(intent)
        }


        categoriesVM.postsData.observe(this, Observer {
            with(categoriesVM) {
                postsData.observe(this@CategoriesActivity, Observer {
                    categoriesAdapter.setData(it)
                })

                messageData.observe(this@CategoriesActivity, Observer {
                    Toast.makeText(this@CategoriesActivity, it, Toast.LENGTH_SHORT).show()
                })

                showProgressbar.observe(this@CategoriesActivity, Observer { isVisible ->
                    pb_categories.visibility = if (isVisible) View.VISIBLE else View.GONE
                })
            }
        })



        with(rv_categories) {
            layoutManager =
                GridLayoutManager(this@CategoriesActivity, 3, GridLayoutManager.VERTICAL, false)
            overScrollMode = View.OVER_SCROLL_NEVER
            setHasFixedSize(true)
            adapter = categoriesAdapter
        }
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.img_to_favorite -> {
                val intent = Intent(this, FavoriteActivity::class.java)
                startActivity(intent)
            }

            R.id.img_to_search -> {
                val uri = Uri.parse("mealrecipes://search")
                startActivity(Intent(Intent.ACTION_VIEW, uri))
            }
        }
    }


}