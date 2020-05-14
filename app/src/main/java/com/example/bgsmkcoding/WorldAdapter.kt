package com.example.bgsmkcoding

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.world_corona_item.*

class WorldAdapter(private val context: Context, private val items:List<WorldCoronaItem>, private val listener: (WorldCoronaItem)->Unit):
    RecyclerView.Adapter<WorldAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    )= ViewHolder(
        context,
        LayoutInflater.from(context).inflate(
            R.layout.world_corona_item,
            parent,
            false
        )
    )

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items.get(position), listener)
    }

    class ViewHolder(val context: Context, override val containerView: View): RecyclerView.ViewHolder(containerView),
        LayoutContainer {
        fun bindItem(item: WorldCoronaItem, listener: (WorldCoronaItem) -> Unit){
            txtCountry.text = item.combinedKey
            txtConfirmed.text = item.confirmed.toString()
            txtRecovered.text = item.recovered.toString()
            txtDeaths.text = item.deaths.toString()

//            Glide.with(context).load("https://www.countryflags.io/"+item.iso2+"/flat/32.png").into(imgCountry)

            containerView.setOnClickListener{listener(item)}
        }
    }
}