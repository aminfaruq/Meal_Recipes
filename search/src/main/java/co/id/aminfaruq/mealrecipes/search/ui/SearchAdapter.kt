package co.id.aminfaruq.mealrecipes.search.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import co.id.aminfaruq.core.domain.model.Search
import co.id.aminfaruq.mealrecipes.search.R
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_search_meals.view.*
import java.util.ArrayList

class SearchAdapter(private val onItemClick: OnItemClick) :
    RecyclerView.Adapter<SearchAdapter.ViewHolder>() {

    private var listData = ArrayList<Search>()

    fun setData(newListData: List<Search>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_search_meals, parent, false)
        )


    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        fun bind(data: Search) {
            with(itemView) {
                val drawable =
                    ContextCompat.getDrawable(view.context, R.drawable.photos_round_shape)
                img_search.clipToOutline = true
                img_search.background = drawable
                Glide.with(itemView.context)
                    .load(data.strMealThumb)
                    .into(img_search)
                tv_name.text = data.strMeal
                tv_category.text = "category : ${data.strCategory}"

                view.setOnClickListener {
                    onItemClick.onClick(data)
                }
            }
        }
    }

    interface OnItemClick {
        fun onClick(item: Search)
    }
}