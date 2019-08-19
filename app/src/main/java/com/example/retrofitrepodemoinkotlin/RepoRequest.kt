package com.example.retrofitrepodemoinkotlin

import com.example.retrofitrepodemoinkotlin.model.ModelRepo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RepoRequest {

    @GET("/users/{user}/repos")
    fun getUserRepo(@Path("user") user : String): Call<List<ModelRepo>>
}
