package com.example.ohood_alharthi_beltexam2

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ohood_alharthi_beltexam_2.LocalDBFragment
import com.example.ohood_alharthi_beltexam_2.R
import kotlinx.android.synthetic.main.item_row2.view.*

class RecyclerViewAdapter2( val localDBFragment:LocalDBFragment) : RecyclerView.Adapter<RecyclerViewAdapter2.ItemViewHolder>() {
    private var tvShow = listOf<TvShow>()
    val TAG = "Adapter2"
    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_row2, parent,false))
    }


    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val info = tvShow[position]

        Log.d(TAG,"SUMMARY${info.summary}")




        holder.itemView.apply {
            nameTv.text =info.name
            LangTv.text = info.language
            dateTV.text = "${info.ended}- ${info.premiered}"
            ratingTv.text = info.rating





            if (info.image!=null){
                Glide.with(context)
                    .load(info.image)
                    .into(imageViewT)
            }
            else {

//                Glide.with(context)
//                    .load(R.drawable.image_search)
//                    .into(imageViewT)
//               setBackgroundResource(R.drawable.image_search)
//                imageViewT.setImageResource( R.drawable.image_search)
//              var noImage =   ResourcesCompat.getDrawable(context.resources,R.drawable.image_search,null)
//                imageViewT.setImageDrawable(noImage)
//                imageViewT.setBackgroundResource(R.drawable.image_search)
            }

            holder.itemView.setOnClickListener{
                Toast.makeText(context, "${info.summary}", Toast.LENGTH_LONG).show()
            }

            deleteBu.setOnClickListener {
                localDBFragment.deleteTvShow(info)
                Toast.makeText(context, "deleted", Toast.LENGTH_LONG).show()
            }






        }
    }

    override fun getItemCount() = tvShow.size

        fun updateRV(tvShw: List<TvShow>) {
        this.tvShow = tvShw
        notifyDataSetChanged()
    }
}

