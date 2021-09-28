package co.id.myapplication.presenter.posts

import co.id.myapplication.data.model.ResponsePosts

interface PostContract {
    interface View{
        fun onFail()
        fun onGetPosts()
        fun onSuccess(listPost: List<ResponsePosts>?)
    }

    interface Presenter {
        fun getPosts()
    }
}