package com.example.hello
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
    @POST("register")
    fun registerStudent(@Body requestBody: RequestBody): Call<RegistrationResponse>
}

interface Call<T> {

}

annotation class RequestBody

annotation class Body

annotation class POST(val APi: String)
}