package com.example.globant.sampleapp.users.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.globant.sampleapp.global.Constants;
import com.example.globant.sampleapp.R;
import com.example.globant.sampleapp.db.entities.User;
import com.example.globant.sampleapp.posts.activity.PostsActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by raul.striglio on 16/01/18.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    private List<User> usersList;
    private Context context;


    public UserAdapter(List<User> usersList, Context context) {
        this.usersList = usersList;
        this.context = context;
    }


    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        StringBuilder sb = new StringBuilder();

        final User user = usersList.get(position);
        sb.append(user.name);
        sb.append(", ");
        sb.append(user.userName);
        sb.append(", ");
        sb.append(user.getAddress().toString());
        sb.append("\n");

        holder.userData.setText(sb.toString());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, PostsActivity.class);
                intent.putExtra(Constants.USER_ID, String.valueOf(user.getUid()));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.userData)
        TextView userData;

        public UserViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
