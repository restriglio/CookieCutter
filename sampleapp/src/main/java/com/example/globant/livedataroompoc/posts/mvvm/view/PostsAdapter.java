package com.example.globant.livedataroompoc.posts.mvvm.view;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.globant.livedataroompoc.global.Constants;
import com.example.globant.livedataroompoc.R;
import com.example.globant.livedataroompoc.db.entities.Post;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by raul.striglio on 19/01/18.
 */

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostsViewHolder> {

    private List<Post> mPostsList;
    private Context mContext;

    public PostsAdapter(List<Post> postsList, Context context){
        mPostsList = postsList;
        mContext = context;
    }

    @Override
    public PostsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false);
        return new PostsAdapter.PostsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PostsViewHolder holder, int position) {

        Post post = mPostsList.get(position);
        holder.tvTitle.setText(post.getTitle());
        holder.tvBody.setText(post.getBody());

        if(post.getStatus().equals(Constants.STATUS_SYNCING)){
            holder.tvTitle.setTextColor(ContextCompat.getColor(mContext, android.R.color.darker_gray));
            holder.tvBody.setTextColor(ContextCompat.getColor(mContext,  android.R.color.darker_gray));
        } else if(post.getStatus().equals(Constants.STATUS_SYNCED)){
            holder.tvTitle.setTextColor(ContextCompat.getColor(mContext, android.R.color.black));
            holder.tvBody.setTextColor(ContextCompat.getColor(mContext, android.R.color.black));
        } else if(post.getStatus().equals(Constants.STATUS_ERROR)){
            holder.tvTitle.setTextColor(ContextCompat.getColor(mContext, android.R.color.holo_red_dark));
            holder.tvBody.setTextColor(ContextCompat.getColor(mContext, android.R.color.holo_red_dark));
        }
    }

    @Override
    public int getItemCount() {
        return mPostsList.size();
    }

    public class PostsViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_title)
        TextView tvTitle;

        @BindView(R.id.tv_body)
        TextView tvBody;

        public PostsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
