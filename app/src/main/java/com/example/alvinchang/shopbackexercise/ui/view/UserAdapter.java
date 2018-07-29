package com.example.alvinchang.shopbackexercise.ui.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alvinchang.shopbackexercise.MainActivity;
import com.example.alvinchang.shopbackexercise.R;
import com.example.alvinchang.shopbackexercise.model.User;

import java.util.List;

/**
 * Created by alvinchang on 2018/7/17.
 */

public class UserAdapter extends RecyclerView.Adapter<UsersHolder>{
    List<User> mUsers;
    MainActivity mActivity;

    public UserAdapter(List<User> users, MainActivity activity) {
        mUsers = users;
        mActivity = activity;
    }

    @Override
    public UsersHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mActivity).inflate(R.layout.row_users, parent,false);
        UsersHolder usersHolder = new UsersHolder(v);
        return usersHolder;
    }

    @Override
    public void onBindViewHolder(UsersHolder holder, int position) {
        holder.setData(mActivity, mUsers.get(position));
    }

    @Override
    public int getItemCount() {
        return mUsers.size();
    }
}
