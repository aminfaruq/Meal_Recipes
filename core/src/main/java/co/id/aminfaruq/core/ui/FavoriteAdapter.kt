package co.id.aminfaruq.core.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.id.aminfaruq.core.R
import co.id.aminfaruq.core.domain.model.DetailMeal
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_recycler_meal.view.*
import java.util.*

class FavoriteAdapter(private val onItemClick: OnItemClick) :  RecyclerView.Adapter<FavoriteAdapter.ViewHolder>() {

    private var listData = ArrayList<DetailMeal>()

    fun setData(newListData: List<DetailMeal>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder  =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_recycler_meal, parent, false)
        )

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    inner class ViewHolder(private val view : View) : RecyclerView.ViewHolder(view) {

        fun bind(data: DetailMeal) {
            with(itemView) {
                Glide.with(itemView.context)
                    .load(data.strMealThumb)
                    .into(mealThumb)
                mealName.text = data.strMeal

                view.setOnClickListener {
                    onItemClick.onClick(data)
                }
            }
        }

    }

    interface OnItemClick{
        fun onClick(item : DetailMeal)
    }
}