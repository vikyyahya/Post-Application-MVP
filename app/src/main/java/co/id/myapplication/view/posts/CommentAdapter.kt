package co.id.myapplication.view.posts

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.id.myapplication.data.model.CommentsItem
import co.id.myapplication.databinding.ItemCommentBinding

class CommentAdapter(private val commentsItemList: List<CommentsItem?>?, private val context: Context) :
    RecyclerView.Adapter<CommentAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemCommentBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = commentsItemList?.get(position)
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        if (commentsItemList != null) {
            return commentsItemList.size
        }else{
            return 0
        }
    }

    inner class MyViewHolder(private val binding: ItemCommentBinding) :
        RecyclerView.ViewHolder(binding.root) {
            fun bind(item : CommentsItem?) {
                with(binding){
                    tvNameAuthor.text = item?.name
                    tvBodyComment.text = item?.body
                }
            }
    }
}