package bogel.data

import com.example.boss.smkcodingc2.Country
import retrofit2.Call
import retrofit2.http.GET
interface DataService {
    @GET("countries")
    fun getName(): Call<List<Country>>
}