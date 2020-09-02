package co.id.aminfaruq.core.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.id.aminfaruq.core.R
import co.id.aminfaruq.core.domain.model.Meals
import coil.load
import kotlinx.android.synthetic.main.item_recycler_meal.view.*
import java.util.*

class MealsAdapter(private val onItemClick: OnItemClick) : RecyclerView.Adapter<MealsAdapter.ViewHolder>() {

    private var listData = ArrayList<Meals>()

    fun setData(newListData: List<Meals>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
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

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        fun bind(data: Meals) {
            with(itemView) {
                mealThumb.load(data.strMealThumb)
                mealName.text = data.strMeal

                view.setOnClickListener {
                    onItemClick.onClick(data)
                }
            }
        }

    }

    interface OnItemClick{
        fun onClick(item : Meals)
    }
}