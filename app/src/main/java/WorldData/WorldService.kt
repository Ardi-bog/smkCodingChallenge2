package WorldData

import com.example.bgsmkcoding.WorldCoronaItem
import retrofit2.Call
import retrofit2.http.GET

interface WorldService {
    @GET("confirmed")
    fun getWorld(): Call<List<WorldCoronaItem>>
}