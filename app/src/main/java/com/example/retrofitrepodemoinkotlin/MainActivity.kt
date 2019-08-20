package com.example.retrofitrepodemoinkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.retrofitrepodemoinkotlin.model.ModelRepo
import com.example.retrofitrepodemoinkotlin.network.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val repoRequest = RetrofitInstance().retrofitInstance.create(RepoRequest::class.java)
        val call = repoRequest.getUserRepo(Constants.USER_NAME)
        call.enqueue(object : Callback<List<ModelRepo>> {
            override fun onFailure(call: Call<List<ModelRepo>>, t: Throwable) {
            }

            override fun onResponse(call: Call<List<ModelRepo>>, response: Response<List<ModelRepo>>) {
                val res = response.body()
                Log.d("MainActivity", res!![0].name)
            }
        })
    }
}
