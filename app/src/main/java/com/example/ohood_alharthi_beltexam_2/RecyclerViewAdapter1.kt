package com.example.ohood_alharthi_beltexam2

import com.example.ohood_alharthi_beltexam_2.API.TvItem
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.ohood_alharthi_beltexam_2.R
import com.example.ohood_alharthi_beltexam_2.SearchFragment
import kotlinx.android.synthetic.main.item_row1.view.*

class RecyclerViewAdapter1 (var tv:ArrayList<TvItem>, val searchFragment:SearchFragment ) : RecyclerView.Adapter<RecyclerViewAdapter1.ItemViewHolder>() {

    val TAG = "Adapter1"

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_row1, parent,false))
    }


    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val info = tv[position]

        Log.d(TAG, "onBindViewHolder: ${info.show.image?.original}")

        holder.itemView.apply {
           showTv.text = info.show.name


            holder.itemView.setOnClickListener {
                var name = info.show.name
                var summary = info.show.summary.toString()
                var lanuage = info.show.language
                var urlImage = info.show.image?.medium
                var premiered = info.show?.premiered.toString()
                var ended = info.show?.ended.toString()
                var rating = info.show.rating?.average.toString()
                searchFragment.addTvShowToDB(TvShow(0, name,lanuage ,summary,urlImage.toString(),premiered,ended,rating))
                Toast.makeText(context, "Added to Data Base ", Toast.LENGTH_LONG).show()


            }


        }
    }

    override fun getItemCount() = tv.size


}


