package co.id.myapplication.data.network

import co.id.myapplication.data.model.ResponseDetailPost
import co.id.myapplication.data.model.ResponsePosts
import co.id.myapplication.data.model.ResponseUser
import co.id.myapplication.data.model.ResponseUserAlbum
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("posts?_expand=user")
    fun getPost() : Call<List<ResponsePosts>>

    @GET("posts/{id_post}?_embed=comments")
    fun getDetailPost( @Path("id_post")  idPost : Int ) : Call<ResponseDetailPost>

    @GET("users/{id_user}/albums?_embed=photos")
    fun getDetailUserAlbum( @Path("id_user")  idUser : Int ) : Call<List<ResponseUserAlbum>>

    @GET("users/{id_user}")
    fun getDetailUser( @Path("id_user")  idUser : Int ) : Call<ResponseUser>

}