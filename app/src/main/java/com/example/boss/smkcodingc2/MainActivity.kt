package com.example.boss.smkcodingc2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import com.example.boss.smkcodingc2.R
import com.example.boss.smkcodingc2.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy
import kotlinx.android.synthetic.main.activity_main.*
class MainActivity : AppCompatActivity() {
    val menuTeks = arrayOf("Negara", "Data", "Profil")
    val manuIcon = arrayOf(
        R.drawable.ic_map, R.drawable.ic_planet,
        R.drawable.ic_avatar)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val adapter = ViewPagerAdapter(this)
        view_pager.setAdapter(adapter);
        TabLayoutMediator(tab_layout, view_pager,
            TabLayoutMediator.TabConfigurationStrategy { tab, position ->
                tab.text = menuTeks[position]
                tab.icon = ResourcesCompat.getDrawable(
                    resources,

                    manuIcon[position], null
                )

            }).attach()
    }
}