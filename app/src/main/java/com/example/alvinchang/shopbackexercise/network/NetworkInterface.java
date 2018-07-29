package com.example.alvinchang.shopbackexercise.network;

import com.example.alvinchang.shopbackexercise.model.User;
import com.example.alvinchang.shopbackexercise.model.UserDetail;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by alvinchang on 2018/7/29.
 */

public interface NetworkInterface {

    @GET("users?since=0&per_page=100")
    Observable<List<User>> getUsers();

    @GET("users/{login}")
    Observable<UserDetail> getUser(@Path("login") String login);
}