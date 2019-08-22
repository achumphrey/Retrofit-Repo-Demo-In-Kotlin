package com.example.moviekotlin.presenter

import com.example.retrofitrepodemoinkotlin.Constants
import com.example.retrofitrepodemoinkotlin.RepoRequest
import com.example.retrofitrepodemoinkotlin.model.ModelRepo
import com.example.retrofitrepodemoinkotlin.network.github.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepoPresenter: BasePresenter<RepoView>(){

    override fun onViewAttached(view: RepoView) {
        super.onViewAttached(view)

        view.showLoading()

        val movieRequest = RetrofitInstance().retrofitInstance.create(RepoRequest::class.java)
        val call = movieRequest.getUserRepo(Constants.USER_NAME)

        call.enqueue(object : Callback<List<ModelRepo>> {

            override fun onFailure(call: Call<List<ModelRepo>>, t: Throwable) {
            }

            override fun onResponse(call: Call<List<ModelRepo>>, response: Response<List<ModelRepo>>) {

                val repoResult = response.body()
                view.showModelRepo(repoResult!!)
            }
        })
    }
}
interface RepoView: BasePresenter.View{

    fun showLoading()
    fun showModelRepo(modelRepo: List<ModelRepo>)

}