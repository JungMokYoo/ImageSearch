package com.example.airproject

import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.QueryMap

interface NetworkInterface {

    interface NetworkInterface {

        @Headers("Authorization: KakaoAK 174781f44e1c2ea06fefe4d1536b74e3")
        @GET("v2/search/image")
        suspend fun search(@QueryMap param: HashMap<String, String>) : ImageModel
    }
}