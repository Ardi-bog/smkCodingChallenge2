package bogel.util

import android.content.Context
import android.widget.Toast
import com.example.boss.smkcodingc2.Country

fun tampilToast(context: Context, message: Country) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}