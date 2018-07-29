package com.example.alvinchang.shopbackexercise;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.alvinchang.shopbackexercise.model.User;
import com.example.alvinchang.shopbackexercise.model.UserDetail;
import com.example.alvinchang.shopbackexercise.network.NetworkClient;
import com.example.alvinchang.shopbackexercise.network.NetworkInterface;
import com.example.alvinchang.shopbackexercise.ui.DisplayInterface;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by alvinchang on 2018/7/29.
 */

public class Presenter {
    private DisplayInterface mDisplayInterface = null;
    private NetworkInterface mNetworkInterface;

    public Presenter() {
        mNetworkInterface = NetworkClient.getRetrofit().create(NetworkInterface.class);

    }

    public void setDisplayInterface(DisplayInterface di) {
        mDisplayInterface = di;
    }

    public void getUsers() {
        mNetworkInterface.getUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(getUsersObserver());
    }

    public void getUserDetail(String login) {
        mNetworkInterface.getUser(login)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(getUserObserver());
    }

    public DisposableObserver<List<User>> getUsersObserver(){
        return new DisposableObserver<List<User>>() {

            @Override
            public void onNext(@NonNull List<User> users) {
                mDisplayInterface.displayData(users);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onComplete() {
            }
        };
    }

    public DisposableObserver<UserDetail> getUserObserver(){
        return new DisposableObserver<UserDetail>() {

            @Override
            public void onNext(@NonNull UserDetail user) {
                if (mDisplayInterface != null) {
                    mDisplayInterface.displayData(user);
                }
            }

            @Override
            public void onError(@NonNull Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onComplete() {
            }
        };
    }
}
