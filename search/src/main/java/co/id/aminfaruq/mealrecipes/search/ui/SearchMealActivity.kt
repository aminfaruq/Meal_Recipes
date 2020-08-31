package co.id.aminfaruq.mealrecipes.search.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import co.id.aminfaruq.core.domain.model.Search
import co.id.aminfaruq.mealrecipes.search.R
import co.id.aminfaruq.mealrecipes.search.di.searchModule
import co.id.aminfaruq.mealrecipes.ui.detail.DetailMealActivity
import kotlinx.android.synthetic.main.activity_searchmeal.*
import kotlinx.coroutines.Job
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.core.context.loadKoinModules

class SearchMealActivity : AppCompatActivity() {

    private val searchVM: SearchVM by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_searchmeal)
        loadKoinModules(searchModule)

        var job: Job? = null
        etSearch.addTextChangedListener { editable ->
            job?.cancel()
            job = MainScope().launch {
                delay(500L)
                editable?.let {
                    if (editable.toString().isNotEmpty()) {
                        searchVM.getMeals(editable.toString())
                    }
                }
            }
        }

        val searchAdapter = SearchAdapter(object : SearchAdapter.OnItemClick {
            override fun onClick(item: Search) {
                val intent = Intent(this@SearchMealActivity, DetailMealActivity::class.java)
                intent.putExtra(DetailMealActivity.EXTRA_MEAL, item.idMeal)
                startActivity(intent)
            }
        })

        searchVM.postsData.observe(this, Observer {
            with(searchVM) {
                postsData.observe(this@SearchMealActivity, Observer {
                    searchAdapter.setData(it)
                })

                messageData.observe(this@SearchMealActivity, Observer {
                    Toast.makeText(this@SearchMealActivity, it, Toast.LENGTH_SHORT).show()
                })

                showProgressbar.observe(this@SearchMealActivity, Observer { isVisible ->
                    pb_search.visibility = if (isVisible) View.VISIBLE else View.GONE
                })
            }
        })

        with(rv_search) {
            layoutManager =
                LinearLayoutManager(this@SearchMealActivity)
            overScrollMode = View.OVER_SCROLL_NEVER
            setHasFixedSize(true)
            adapter = searchAdapter
        }


    }
}