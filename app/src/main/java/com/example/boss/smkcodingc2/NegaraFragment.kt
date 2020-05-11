package com.example.boss.smkcodingc2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import com.example.boss.smkcodingc2.R

import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_negara.*


class NegaraFragment : Fragment() {
    lateinit var listTeman : ArrayList<negara>
    private fun simulasiDataTeman() {
        listTeman = ArrayList()
        listTeman.add(negara("Fakhry", "Laki-laki", "fakhry@smkcoding.id",
            "081123123123", "Malang"))
        listTeman.add(negara("Ahmad", "Laki-laki", "ahmad@smkcoding.id",
            "085123123123", "Malang"))
    }
    private fun tampilTeman() {
        rv_listMyFriends.layoutManager = LinearLayoutManager(activity)
        rv_listMyFriends.adapter = NegaraAdapter(activity!!, listTeman)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
// Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_negara, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }
    private fun initView() {
        simulasiDataTeman()
        tampilTeman()
    }
    override fun onDestroy() {
        super.onDestroy()
        this.clearFindViewByIdCache()
    }
}