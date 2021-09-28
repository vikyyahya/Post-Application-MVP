package co.id.myapplication.presenter.user

import co.id.myapplication.data.model.ResponseUser
import co.id.myapplication.data.model.ResponseUserAlbum

interface DetailUserContract {

    interface View{
        fun onFailGetDetailUser()
        fun onGetDetailUser()

        fun onFailGetAlbums()
        fun onGetAlbums()


        fun onSuccessGetAlbums(responseAlbum: List<ResponseUserAlbum>?)
        fun onSuccessGetUser(responseAlbum: ResponseUser?)
    }

    interface Presenter {
        fun getDetailUser(idUser : Int)
        fun getListAlbum(idUser : Int)
    }
}