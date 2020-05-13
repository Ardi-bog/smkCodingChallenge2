package bogel.util

import android.content.Context
import android.support.v4.widget.SwipeRefreshLayout
import android.view.View
import androidx.core.content.ContextCompat
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.boss.smkcodingc2.R

fun showLoading(context: Context, swipeRefreshLayout: View) {
    swipeRefreshLayout.setColorSchemeColors(ContextCompat.getColor(context,
        R.color.colorPrimary))
    swipeRefreshLayout.isEnabled = true
    swipeRefreshLayout.isRefreshing = true
}
fun dismissLoading(swipeRefreshLayout: SwipeRefreshLayout) {
    swipeRefreshLayout.isRefreshing = false
    swipeRefreshLayout.isEnabled = false
}