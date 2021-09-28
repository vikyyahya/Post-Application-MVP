package co.id.myapplication.presenter.posts

import co.id.myapplication.data.model.ResponseDetailPost
import co.id.myapplication.data.network.ConfigRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailPostPresenter(private val view : DetailPostContract.View ) : DetailPostContract.Presenter {

    override fun getDetailPostPosts(idPost : Int) {

        ConfigRetrofit.getService().getDetailPost(idPost).enqueue(object : Callback<ResponseDetailPost>{
            override fun onResponse(
                call: Call<ResponseDetailPost>,
                response: Response<ResponseDetailPost>
            ) {
                view.onSuccessGetDetailPost(response.body())
            }

            override fun onFailure(call: Call<ResponseDetailPost>, t: Throwable) {
                view.onFailGetDetailPost()
            }

        })
    }
}