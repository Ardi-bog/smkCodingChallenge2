package com.example.boss.smkcodingc2

import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.telecom.Call
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import bogel.data.DataService
import bogel.data.apiRequest
import bogel.data.httpClient
import bogel.util.dismissLoading
import bogel.util.showLoading
import bogel.util.tampilToast
import kotlinx.android.synthetic.main.fragment_data.*
import okhttp3.Response
import javax.security.auth.callback.Callback

class DataFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(
            R.layout.fragment_data,

            container, false)
    }
    override fun onViewCreated(
        view: View,
        @Nullable savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
    }
    private fun callApiGetNameCountry() {
        showLoading(this.context!!, this.swipeRefreshLayout)
        val httpClient = httpClient()
        val apiRequest = apiRequest<DataService>(httpClient)

        val call = apiRequest.getName().also {
            it.enqueue(object: Callback<List<Country>> {
               override fun onFailure(call: Call<List<Country>>, t: Throwable) {
                    dismissLoading(this@DataFragment.swipeRefreshLayout as SwipeRefreshLayout)
                }

                override fun onResponse(call: Call<List<Country>>, response:
                Response<List<Country>>
                ) {
                    dismissLoading(this@DataFragment.swipeRefreshLayout as SwipeRefreshLayout)
                    when {
                        response.isSuccessful ->
                            when {
                                response.body()?.size != 0 ->
                                    this@DataFragment.tampilData(response.body()!!)
                                else -> {
                                    tampilToast(this@DataFragment.context!!, "Berhasil")
                                }
                            }
                        else -> {
                            tampilToast(this@DataFragment.context!!, "Gagal")
                        }
                    }
                }
            })
        }
    }
    private fun tampilData(githubUsers: List<Country>) {
        this.listCountry.layoutManager = LinearLayoutManager(this.context)
        this.listCountry.adapter = DataAdapter(this.context!!, githubUsers) {
            val country = it
            tampilToast(this.context!!, country)
        }
    }
}