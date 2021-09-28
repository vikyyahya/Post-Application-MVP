package co.id.myapplication.view.posts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import co.id.myapplication.data.model.ResponseDetailPost
import co.id.myapplication.databinding.ActivityDetailPostBinding
import co.id.myapplication.presenter.posts.DetailPostContract
import co.id.myapplication.presenter.posts.DetailPostPresenter
import co.id.myapplication.view.user.DetailUserActivity

class DetailPostActivity : AppCompatActivity() , DetailPostContract.View{
    lateinit var binding: ActivityDetailPostBinding
    lateinit var detailPostPresenter: DetailPostPresenter

    var idUser: Int = 0
    var nameUser: String = ""
    var idPost: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailPostBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
    }

    private fun init(){
        val actionBar = supportActionBar
        actionBar!!.title = "Detail Post"
        var bundle :Bundle ?=intent.extras
        idUser = bundle!!.getInt("idUser")
        nameUser = bundle!!.getString("nameUser").toString()
        idPost = bundle!!.getInt("idPost")
        binding.tvUserName.text = nameUser


        detailPostPresenter = DetailPostPresenter(this)
        detailPostPresenter.getDetailPostPosts(idPost)

        binding.tvUserName.setOnClickListener {
            val intent = Intent(this, DetailUserActivity::class.java).apply {
                putExtra("idUser",idUser)
            }
            startActivity(intent)
        }

    }

    override fun onFailGetDetailPost() {

    }

    override fun onGetDetailPosts() {

    }

    override fun onSuccessGetDetailPost(responseDetailPost: ResponseDetailPost?) {
        binding.tvTitlePost.text = responseDetailPost?.title
        binding.tvBodyPost.text = responseDetailPost?.body

        val commentAdapter = CommentAdapter(responseDetailPost?.comments,this)

        with(binding.rvComments) {
            layoutManager = LinearLayoutManager(this@DetailPostActivity)
            setHasFixedSize(true)
            adapter = commentAdapter
        }

    }
}