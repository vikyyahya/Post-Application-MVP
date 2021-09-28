package co.id.myapplication.presenter.user

import co.id.myapplication.data.model.ResponseUser
import co.id.myapplication.data.model.ResponseUserAlbum
import co.id.myapplication.data.network.ConfigRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailUserPresenter(private val view : DetailUserContract.View) : DetailUserContract.Presenter {

    override fun getDetailUser(idUser: Int) {
        ConfigRetrofit.getService().getDetailUser(idUser).enqueue(object : Callback<ResponseUser>{
            override fun onResponse(call: Call<ResponseUser>, response: Response<ResponseUser>) {
                view.onSuccessGetUser(response.body())
            }

            override fun onFailure(call: Call<ResponseUser>, t: Throwable) {
                view.onFailGetDetailUser()
            }

        })
    }

    override fun getListAlbum(idUser: Int) {
        ConfigRetrofit.getService().getDetailUserAlbum(idUser).enqueue(object  : Callback<List<ResponseUserAlbum>>{
            override fun onResponse(
                call: Call<List<ResponseUserAlbum>>,
                response: Response<List<ResponseUserAlbum>>
            ) {
                view.onSuccessGetAlbums(response.body())
            }

            override fun onFailure(call: Call<List<ResponseUserAlbum>>, t: Throwable) {
                view.onFailGetAlbums()
            }

        })
    }
}