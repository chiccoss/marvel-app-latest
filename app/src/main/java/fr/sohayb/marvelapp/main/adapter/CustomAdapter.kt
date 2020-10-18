package fr.sohayb.marvelapp.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import fr.sohayb.marvelapp.R
import fr.sohayb.marvelapp.main.data.Result
import kotlinx.android.synthetic.main.item_result.view.*


class CustomAdapter(private val didClickItem: (Result) -> Unit) : ListAdapter<Result, CustomAdapter.MyEventsViewHolder>(DiffItemCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyEventsViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_result, parent, false)
        return MyEventsViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyEventsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class MyEventsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(result: Result) {
            itemView.itemResultUserProfileTv.text = result.name
            //itemView.itemResultEvaluationNumberTv.text = result.comics.items[0].name
            itemView.itemResultScoreTv.text= result.id.toString()


            itemView.setOnClickListener {
                didClickItem.invoke(result)
            }
        }
    }

    class DiffItemCallback : DiffUtil.ItemCallback<Result>() {
        override fun areContentsTheSame(
            oldItem: Result,
            newItem: Result
        ): Boolean {
            return oldItem == newItem
        }

        override fun areItemsTheSame(
            oldItem: Result,
            newItem: Result
        ): Boolean {
            return oldItem.id == newItem.id
        }
    }
}
