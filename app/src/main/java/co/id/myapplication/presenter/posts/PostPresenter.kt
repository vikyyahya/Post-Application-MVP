package co.id.myapplication.presenter.posts

import android.util.Log
import co.id.myapplication.data.model.ResponsePosts
import co.id.myapplication.data.network.ConfigRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostPresenter(private val view : PostContract.View) : PostContract.Presenter {

    override fun getPosts() {
        view.onGetPosts()
        Log.v("dataRe","= getPosts")


       ConfigRetrofit.getService().getPost().enqueue(object : Callback<List<ResponsePosts>> {
            override fun onResponse(call: Call<List<ResponsePosts>>, response: Response<List<ResponsePosts>>) {
                view.onSuccess(response.body())
                Log.v("dataRe","= onResponse")

            }

            override fun onFailure(call: Call<List<ResponsePosts>>, t: Throwable) {
                view.onFail()
                Log.v("dataRe","= onFailure "+ t.message)

            }

        })

    }
}