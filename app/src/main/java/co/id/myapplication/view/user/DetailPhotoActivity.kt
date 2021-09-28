package co.id.myapplication.view.user

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.id.myapplication.databinding.ActivityDetailPhotoBinding
import com.squareup.picasso.Picasso

class DetailPhotoActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailPhotoBinding
    var title : String = ""
    var url : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailPhotoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
    }

    private fun init(){
        val actionBar = supportActionBar
        actionBar!!.title = "Detail Photo"
        var bundle :Bundle ?=intent.extras
        title = bundle!!.getString("title").toString()
        url = bundle!!.getString("url").toString()

        with(binding){
            tvTitle.text = title
            val picasso = Picasso.get()
            picasso.load(url).into(photoView)
        }

    }
}