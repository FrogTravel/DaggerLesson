package snu.kr.daggerlesson.ui.main.util

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.post_card.view.*
import snu.kr.daggerlesson.R
import snu.kr.daggerlesson.model.Post

class PostAdapter(val posts: List<Post>) : RecyclerView.Adapter<PostAdapter.ViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(viewGroup.context).inflate(R.layout.post_card, null))
    }

    override fun getItemCount() = posts.size

    override fun onBindViewHolder(viewHolder: ViewHolder, id: Int) {
        viewHolder.view.titleTextView.text = posts[id].title
    }

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view)
}