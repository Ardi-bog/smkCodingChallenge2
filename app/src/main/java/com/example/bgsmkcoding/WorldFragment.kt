package com.example.bgsmkcoding

import WorldData.WorldService
import WorldData.apiRequest
import WorldData.httpClient
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_world.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import util.dismissLoading
import util.showLoading
import util.tampilToast

/**
 * A simple [Fragment] subclass.
 */
class WorldFragment : Fragment() {

    private fun callApiGetCovidGlobal(){
        showLoading(context!!, swipeRefreshLayout)

        val httpClient = httpClient()
        val apiRequest = apiRequest<WorldService>(httpClient)

        val call = apiRequest.getWorld()
        call.enqueue(object : Callback<List<WorldCoronaItem>> {
            override fun onFailure(call: Call<List<WorldCoronaItem>>, t: Throwable) {
                dismissLoading(swipeRefreshLayout)
            }

            override fun onResponse(
                call: Call<List<WorldCoronaItem>>,
                response: Response<List<WorldCoronaItem>>
            ) {
                dismissLoading(swipeRefreshLayout)

                when{
                    response.isSuccessful->
                        when{
                            response.body()?.size != 0 ->
                                tampilCovidGlobal(response.body()!!)
                            else->{
                                tampilToast(context!!, "Berhasil")
                            }
                        }
                    else->
                        tampilToast(context!!, ".")
                }
            }
        })
    }

    private fun tampilCovidGlobal(covidGlobals: List<WorldCoronaItem>){
        listWorldCorona.layoutManager = LinearLayoutManager(context)
        listWorldCorona.adapter =
            WorldAdapter(
                context!!,
                covidGlobals
            ) {

                val covidGlobal = it
                tampilToast(context!!, covidGlobal.combinedKey)
            }
    }

    override  fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_world, container, false)
    }

    override fun onViewCreated(view: View,@Nullable savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        callApiGetCovidGlobal()
    }

}
