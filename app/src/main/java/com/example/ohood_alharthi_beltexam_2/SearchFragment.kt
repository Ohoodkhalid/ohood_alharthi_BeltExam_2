package com.example.ohood_alharthi_beltexam_2

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ohood_alharthi_beltexam2.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.example.ohood_alharthi_beltexam_2.API.APIClient
import com.example.ohood_alharthi_beltexam_2.API.APIInterface
import com.example.ohood_alharthi_beltexam_2.API.TvItem

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class SearchFragment : Fragment() {
    private val TvShowViewModel by lazy { ViewModelProvider(this).get(TvViewModel::class.java) }
    lateinit var recView1: RecyclerView
    lateinit var adapter1: RecyclerViewAdapter1
    var  tv = ArrayList<TvItem>()
    lateinit var searchET: EditText
    lateinit var search_button: Button
    val TAG = "SearchFragment"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view  =inflater.inflate(R.layout.fragment_search, container, false)

        searchET = view.findViewById(R.id.searchET)
        search_button=view.findViewById(R.id.search_button)

        recView1= view.findViewById(R.id.recView1)
        adapter1=RecyclerViewAdapter1(tv,this)
        recView1.adapter = adapter1
        recView1.layoutManager = LinearLayoutManager(requireContext())

        search_button.setOnClickListener{
            var searchText = searchET.text.toString()
            if(searchText.isNotEmpty()){
                getData(searchText)
            }

        }

        return view
    }

    fun getData(searchText:String){

        val apiInterface = APIClient().getClient()?.create(APIInterface::class.java)

        apiInterface?.getData(searchText)?.enqueue(object : Callback<List<TvItem>> {
            override fun onResponse(call: Call<List<TvItem>>, response: Response<List<TvItem>>) {
                Toast.makeText(context, "success", Toast.LENGTH_LONG).show()

                for (i in 0..response.body()!!.size){
                    for(data in response.body()!!){

                        tv.add(data)

                        Log.d(TAG, "success: $data")
                    }
                    adapter1.notifyDataSetChanged()
                }

            }
            override fun onFailure(call: Call<List<TvItem>>, t: Throwable) {
                Toast.makeText(context, "ERROR", Toast.LENGTH_LONG).show()
            }
        })
    }


    fun addTvShowToDB(tvShow:TvShow){
        TvShowViewModel.addTvShow(tvShow)


    }

    }


