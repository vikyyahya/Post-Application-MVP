package co.id.myapplication.view.user

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.id.myapplication.R
import co.id.myapplication.data.model.PhotosItem
import co.id.myapplication.databinding.ItemAlbumBinding
import co.id.myapplication.databinding.ItemCommentBinding
import co.id.myapplication.databinding.ItemThumbnailBinding
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso

class ThumbnailAdapter(private val listPhoto :List<PhotosItem?>?): RecyclerView.Adapter<ThumbnailAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemThumbnailBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(binding)    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = listPhoto?.get(position)
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        if (listPhoto != null) {
            return listPhoto.size
        }else{
            return 0
        }
    }

    inner class MyViewHolder(private val binding: ItemThumbnailBinding) :
        RecyclerView.ViewHolder(binding.root) {
            fun bind(item : PhotosItem?){
                with(binding){
                    val picasso = Picasso.get()
                    picasso.load(item?.thumbnailUrl)
                        .into(ivThumbnail)
                    tvTitleThumbnail.text = item?.title
                    cvThumbnail.setOnClickListener {
                        val intent = Intent(itemView.context,DetailPhotoActivity::class.java).apply {
                            putExtra("title",item?.title)
                            putExtra("url",item?.url)
                        }
                        itemView.context.startActivity(intent)
                    }
                }
            }
    }
}