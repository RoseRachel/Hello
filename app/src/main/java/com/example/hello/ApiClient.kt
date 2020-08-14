package com.example.hello


import android.database.sqlite.SQLiteDatabase.create
import okHttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.URI.create

object ApiClient{
    var client = OkHttpClient.Builder().build()

    var retrofit = Retrofit.Builder()
        .baseUrl("https://courses-service.herokuapp.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    fun <T> buildService(service: Class<T>): T {
        return retrofit.create(service)
    }
}

private fun Any.client(client: OkHttpClient.api): Any {
    TODO("Not yet implemented")
}

private fun Any.addConverterFactory(any: Any): Any {
    TODO("Not yet implemented")
}

class Retrofit {
    class Builder {
        fun baseUrl(s: String): Any {
            TODO("Not yet implemented")
        }

    }

}

class GsonConverterFactory {

}

class OkHttpClient {
    class Builder {
        fun build(): api {
            TODO("Not yet implemented")
        }

    }

    class api {

    }

}
