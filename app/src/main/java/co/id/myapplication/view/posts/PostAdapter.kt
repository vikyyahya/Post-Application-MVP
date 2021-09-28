package co.id.myapplication.view.posts

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.id.myapplication.data.model.ResponsePosts
import co.id.myapplication.data.model.ResponsePostsItem
import co.id.myapplication.databinding.ItemPostBinding

class PostAdapter(private val listPost: List<ResponsePosts>?,private val context : Context) : RecyclerView.Adapter<PostAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemPostBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = listPost?.get(position)
        holder.bind(item,context)
    }

    override fun getItemCount(): Int {
        if (listPost != null) {
            return listPost.size
        }else{
            return 0
        }
    }

    inner class MyViewHolder(private val binding: ItemPostBinding) :
        RecyclerView.ViewHolder(binding.root) {
            fun bind(item: ResponsePosts?, context: Context){
                with(binding){
                    tvTitle.text = item?.title
                    tvDescription.text = item?.body
                    tvName.text = item?.user?.name
                    tvCompanyName.text = item?.user?.company?.name
                    cvPost.setOnClickListener {
                        val intent = Intent(context,DetailPostActivity::class.java).apply {
                            putExtra("idPost", item?.id)
                            putExtra("idUser", item?.userId)
                            putExtra("nameUser", item?.user?.username)
                        }
                        context.startActivity(intent)
                    }
                }
            }
    }

}