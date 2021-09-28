package co.id.myapplication.view.user

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.id.myapplication.data.model.ResponseUserAlbum
import co.id.myapplication.databinding.ItemAlbumBinding

class AlbumAdapter(private val listAlbum:List<ResponseUserAlbum>?, private val context: Context) : RecyclerView.Adapter<AlbumAdapter.MyViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumAdapter.MyViewHolder {
        val binding = ItemAlbumBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AlbumAdapter.MyViewHolder, position: Int) {
        val item = listAlbum?.get(position)
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        if (listAlbum != null) {
            return listAlbum.size
        }else{
            return 0
        }
    }

    inner class MyViewHolder(private val binding: ItemAlbumBinding) :
        RecyclerView.ViewHolder(binding.root) {
            fun bind(item : ResponseUserAlbum?){
                with(binding){
                    val thumbnailAdapter = ThumbnailAdapter(item?.photos)
                    tvAlbumName.text = item?.title
                    with(rvListThumbnail){
                        layoutManager = GridLayoutManager(context,3)
                        setHasFixedSize(true)
                        adapter = thumbnailAdapter
                    }


                }
            }
    }
}