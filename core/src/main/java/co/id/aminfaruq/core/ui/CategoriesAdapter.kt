package co.id.aminfaruq.core.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.id.aminfaruq.core.R
import co.id.aminfaruq.core.domain.model.Categories
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_categories.view.*
import java.util.ArrayList

class CategoriesAdapter : RecyclerView.Adapter<CategoriesAdapter.ViewHolder>() {

    private var listData = ArrayList<Categories>()
    var onItemClick: ((Categories) -> Unit)? = null

    fun setData(newListData: List<Categories>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_categories, parent, false)
        )

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: CategoriesAdapter.ViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(data: Categories) {
            with(itemView) {
                Glide.with(itemView.context)
                    .load(data.strCategoryThumb)
                    .into(categoryThumb)
                categoryName.text = data.strCategory
            }
        }

        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(listData[adapterPosition])
            }
        }
    }

}