package co.id.myapplication.presenter.posts

import co.id.myapplication.data.model.ResponseDetailPost

interface DetailPostContract {
    interface View{
        fun onFailGetDetailPost()
        fun onGetDetailPosts()
        fun onSuccessGetDetailPost(responseDetailPost: ResponseDetailPost?)
    }

    interface Presenter {
        fun getDetailPostPosts(idPost : Int)
    }
}