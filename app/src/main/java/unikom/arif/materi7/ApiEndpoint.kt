package unikom.arif.materi7

import retrofit2.Call
import retrofit2.http.GET

interface ApiEndpoint {

    @GET("tampilSemua.php")
    fun data() : Call<ReadModel>

}