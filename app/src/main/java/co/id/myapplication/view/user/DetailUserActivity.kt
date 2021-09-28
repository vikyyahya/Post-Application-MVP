package co.id.myapplication.view.user

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import co.id.myapplication.data.model.ResponseUser
import co.id.myapplication.data.model.ResponseUserAlbum
import co.id.myapplication.databinding.ActivityDetailUserBinding
import co.id.myapplication.presenter.user.DetailUserContract
import co.id.myapplication.presenter.user.DetailUserPresenter

class DetailUserActivity : AppCompatActivity() , DetailUserContract.View{
    lateinit var binding : ActivityDetailUserBinding
    lateinit var detailUserPresenter: DetailUserPresenter
    var idUser : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
    }

    private fun init(){
        val actionBar = supportActionBar
        actionBar!!.title = "Detail User"
        var bundle :Bundle ?=intent.extras
        idUser = bundle!!.getInt("idUser")
        detailUserPresenter = DetailUserPresenter(this)
        detailUserPresenter.getDetailUser(idUser)
        detailUserPresenter.getListAlbum(idUser)
    }

    override fun onFailGetDetailUser() {
        
    }

    override fun onGetDetailUser() {
        
    }

    override fun onFailGetAlbums() {
        
    }

    override fun onGetAlbums() {
        
    }

    override fun onSuccessGetAlbums(responseAlbum: List<ResponseUserAlbum>?) {
        val albumAdapter = AlbumAdapter(responseAlbum,this)
        with(binding.rvAlbum) {
            layoutManager = LinearLayoutManager(this@DetailUserActivity)
            setHasFixedSize(true)
            adapter = albumAdapter
        }
    }

    override fun onSuccessGetUser(responseAlbum: ResponseUser?) {
        binding.tvName.text =responseAlbum?.name
        binding.tvEmail.text =responseAlbum?.email
        binding.tvAddress.text =responseAlbum?.address?.street
        binding.tvCompany.text =responseAlbum?.company?.name
    }
}