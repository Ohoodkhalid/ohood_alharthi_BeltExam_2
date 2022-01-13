package com.example.ohood_alharthi_beltexam_2

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ohood_alharthi_beltexam2.RecyclerViewAdapter2
import com.example.ohood_alharthi_beltexam2.TvShow
import com.example.ohood_alharthi_beltexam2.TvViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER



class LocalDBFragment : Fragment() {
    private val TvShowViewModel by lazy { ViewModelProvider(this).get(TvViewModel::class.java) }
    lateinit var recView2: RecyclerView
    lateinit var adapter2: RecyclerViewAdapter2
    var tvShow = ArrayList<TvShow>()

    @SuppressLint("FragmentLiveDataObserve")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_local_d_b, container, false)


        recView2 = view.findViewById(R.id.recView1)
        adapter2 = RecyclerViewAdapter2(this)
        recView2.adapter = adapter2
        recView2.layoutManager = LinearLayoutManager(requireContext())


        TvShowViewModel.getTvShow().observe(this, {

                tvShow ->
            adapter2.updateRV(tvShow)

        })

        return view
    }




    fun deleteTvShow(tvShow: TvShow) {
        TvShowViewModel.deleteTvShow(tvShow)
    }

}