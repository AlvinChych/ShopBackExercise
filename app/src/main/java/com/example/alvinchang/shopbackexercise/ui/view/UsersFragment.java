package com.example.alvinchang.shopbackexercise.ui.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alvinchang.shopbackexercise.MainActivity;
import com.example.alvinchang.shopbackexercise.Presenter;
import com.example.alvinchang.shopbackexercise.R;
import com.example.alvinchang.shopbackexercise.model.User;
import com.example.alvinchang.shopbackexercise.ui.DisplayInterface;

import java.util.List;

/**
 * Created by alvinchang on 2018/7/28.
 */

public class UsersFragment extends Fragment implements DisplayInterface {

    private SwipeRefreshLayout mRefreshLayout;
    private RecyclerView mUsersList;
    private UserAdapter mAdapter;
    private Presenter mPresenter;
    private MainActivity mActivity = null;
    private List<User> mUsers = null;

    public void onAttach(Context context) {
        super.onAttach(context);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ((AppCompatActivity) getActivity()).getSupportActionBar().show();
        View root = inflater.inflate(R.layout.users_list, container, false);
        return root;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        mActivity = (MainActivity) getActivity();
        mUsersList = (RecyclerView) view.findViewById(R.id.users_recycler_view);
        mUsersList.setLayoutManager(new LinearLayoutManager(mActivity));
        mUsersList.setItemAnimator(new DefaultItemAnimator());
        mRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.users_refresh_layout);
        mRefreshLayout.setColorSchemeColors(ContextCompat.getColor(mActivity, R.color.colorAccent));
        mRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPresenter.getUsers();
            }
        });
        mPresenter = mActivity.getPresenter();
        mPresenter.setDisplayInterface(this);
        if (mUsers == null) {
            mRefreshLayout.setRefreshing(true);
            mPresenter.getUsers();
        } else {
            displayData(mUsers);
        }
    }

    public static UsersFragment newInstance() {
        UsersFragment fragment = new UsersFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void displayData(Object users) {
        if (users != null) {
            mAdapter = new UserAdapter((List<User>) users, mActivity);
            mUsersList.setAdapter(mAdapter);
        }
        mUsers = (List<User>)users;
        mRefreshLayout.setRefreshing(false);
    }
}
