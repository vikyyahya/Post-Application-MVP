package co.id.myapplication.view.posts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import co.id.myapplication.data.model.ResponsePosts
import co.id.myapplication.databinding.ActivityMainBinding
import co.id.myapplication.presenter.posts.PostContract
import co.id.myapplication.presenter.posts.PostPresenter

class MainActivity : AppCompatActivity(), PostContract.View {
    lateinit var binding: ActivityMainBinding
    lateinit var postPresenter: PostPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
    }

    fun init() {
        val actionBar = supportActionBar
        actionBar!!.title = "List Of Post"

        postPresenter = PostPresenter(this)
        postPresenter.getPosts()
    }

    override fun onSuccess(listPost: List<ResponsePosts>?) {
        val postAdapter = PostAdapter(listPost,this)

        with(binding.rvPost) {
            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true)
            adapter = postAdapter
        }
    }

    override fun onFail() {
    }

    override fun onGetPosts() {
    }
}