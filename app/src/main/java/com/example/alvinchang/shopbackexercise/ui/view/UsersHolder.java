package com.example.alvinchang.shopbackexercise.ui.view;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.alvinchang.shopbackexercise.R;
import com.example.alvinchang.shopbackexercise.model.User;
import com.example.alvinchang.shopbackexercise.ui.GlideCircleTransform;

/**
 * Created by alvinchang on 2018/7/17.
 */

public class UsersHolder extends RecyclerView.ViewHolder {

    private TextView mLoginName;
    private ImageView mAvatarImage;
    private TextView mSiteAdmin;
    private View mView;

    public UsersHolder(View v) {
        super(v);
        mLoginName = (TextView) v.findViewById(R.id.login_name);
        mAvatarImage = (ImageView) v.findViewById(R.id.avatar_image);
        mSiteAdmin = (TextView) v.findViewById(R.id.site_admin);
        mView = v;
    }

    public void setData(AppCompatActivity activity, User user) {
        mLoginName.setText(user.getLogin());
        Glide.with(activity).load(user.getAvatar_url()).transform(new GlideCircleTransform(activity)).into(mAvatarImage);
        if (user.getSite_admin()) {
            mSiteAdmin.setVisibility(View.VISIBLE);
        }
        mView.setOnClickListener(new ItemClickHandler(activity, user));
    }

    private class ItemClickHandler implements View.OnClickListener {

        private AppCompatActivity mActivity;
        private User mUser;

        public ItemClickHandler(AppCompatActivity activity, User user) {
            super();
            mActivity = activity;
            mUser = user;
        }

        @Override
        public void onClick(View view) {
            if (getAdapterPosition() != RecyclerView.NO_POSITION) {
                FragmentManager fm = mActivity.getSupportFragmentManager();
                UserDetailFragment fragment = (UserDetailFragment) fm.findFragmentByTag(UserDetailFragment.class.getSimpleName());
                if (fragment == null) {
                    fragment = UserDetailFragment.newInstance();
                }
                Bundle bundle = new Bundle();
                bundle.putParcelable("User", mUser);
                fragment.setArguments(bundle);
                fm.beginTransaction().replace(R.id.container, fragment, UserDetailFragment.class.getSimpleName())
                        .addToBackStack("fname")
                        .commit();
            }
        }
    }
}
