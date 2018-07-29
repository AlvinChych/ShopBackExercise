package com.example.alvinchang.shopbackexercise.ui.view;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.alvinchang.shopbackexercise.MainActivity;
import com.example.alvinchang.shopbackexercise.Presenter;
import com.example.alvinchang.shopbackexercise.R;
import com.example.alvinchang.shopbackexercise.model.User;
import com.example.alvinchang.shopbackexercise.model.UserDetail;
import com.example.alvinchang.shopbackexercise.ui.DisplayInterface;
import com.example.alvinchang.shopbackexercise.ui.GlideCircleTransform;

/**
 * Created by alvinchang on 2018/7/29.
 */

public class UserDetailFragment extends Fragment implements DisplayInterface {

    private User mUser = null;
    private UserDetail mUserDetail = null;
    private ImageView mButton;
    private ImageView mAvatarImage;
    private TextView mSiteAdmin;
    private TextView mName;
    private TextView mBio;
    private TextView mLogin;
    private TextView mLocation;
    private TextView mBlog;
    private SwipeRefreshLayout mRefreshLayout;
    private Presenter mPresenter;

    public void onAttach(Context context) {
        super.onAttach(context);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        View root = inflater.inflate(R.layout.user_detail, container, false);
        return root;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            mUser = bundle.getParcelable("User");
        }
        mButton = (ImageView) view.findViewById(R.id.image_back);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });

        mAvatarImage = (ImageView) view.findViewById(R.id.avatar_image);
        Glide.with(getActivity()).load(mUser.getAvatar_url()).transform(new GlideCircleTransform(getActivity())).into(mAvatarImage);
        mName = (TextView) view.findViewById(R.id.name);
        mBio = (TextView) view.findViewById(R.id.bio);
        mLocation = (TextView) view.findViewById(R.id.location);
        mBlog = (TextView) view.findViewById(R.id.blog);
        mLogin = (TextView) view.findViewById(R.id.login_name);
        mSiteAdmin = (TextView) view.findViewById(R.id.site_admin);
        mRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.user_refresh_layout);
        mRefreshLayout.setColorSchemeColors(ContextCompat.getColor(getActivity(), R.color.colorAccent));
        mRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPresenter.getUserDetail(mUser.getLogin());
            }
        });
        mPresenter = ((MainActivity)getActivity()).getPresenter();
        mPresenter.setDisplayInterface(this);
        if (mUserDetail == null) {
            mRefreshLayout.setRefreshing(true);
            mPresenter.getUserDetail(mUser.getLogin());
        } else {
            displayData(mUserDetail);
        }
    }

    public static UserDetailFragment newInstance() {
        UserDetailFragment fragment = new UserDetailFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void displayData(Object user) {
        if (user != null) {
            mUserDetail = (UserDetail)user;
            mName.setText(mUserDetail.getName());
            mBio.setText(mUserDetail.getBio());
            mLocation.setText(mUserDetail.getLocation());
            mLogin.setText(mUserDetail.getLogin());
            mBlog.setText(mUserDetail.getBlog());
            mBlog.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(mUserDetail.getBlog()));
                    startActivity(browserIntent);
                }
            });
            if (mUserDetail.getSite_admin()) {
                mSiteAdmin.setVisibility(View.VISIBLE);
            }
        }

        mRefreshLayout.setRefreshing(false);
    }
}
