package com.example.retrofitrepodemoinkotlin.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.moviekotlin.presenter.RepoPresenter
import com.example.moviekotlin.presenter.RepoView
import com.example.retrofitrepodemoinkotlin.Constants
import com.example.retrofitrepodemoinkotlin.R
import com.example.retrofitrepodemoinkotlin.RepoRequest
import com.example.retrofitrepodemoinkotlin.model.ModelRepo
import com.example.retrofitrepodemoinkotlin.network.github.RetrofitInstance
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), RepoView {

    val presenter: RepoPresenter = RepoPresenter()

    override fun showLoading() {

        progressBar.visibility = View.VISIBLE

    }

    override fun showModelRepo(modelRepo: List<ModelRepo>) {

        progressBar.visibility = View.GONE
        Log.d("MainActivity", modelRepo!![0].name)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.onViewAttached(this)


/*

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
*/

    }
}
