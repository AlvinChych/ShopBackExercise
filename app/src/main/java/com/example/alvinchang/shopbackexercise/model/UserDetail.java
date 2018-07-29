package com.example.alvinchang.shopbackexercise.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by alvinchang on 2018/7/29.
 */

public class UserDetail {

//        "login": "defunkt",
//        "id": 2,
//        "node_id": "MDQ6VXNlcjI=",
//        "avatar_url": "https://avatars0.githubusercontent.com/u/2?v=4",
//        "gravatar_id": "",
//        "url": "https://api.github.com/users/defunkt",
//        "html_url": "https://github.com/defunkt",
//        "followers_url": "https://api.github.com/users/defunkt/followers",
//        "following_url": "https://api.github.com/users/defunkt/following{/other_user}",
//        "gists_url": "https://api.github.com/users/defunkt/gists{/gist_id}",
//        "starred_url": "https://api.github.com/users/defunkt/starred{/owner}{/repo}",
//        "subscriptions_url": "https://api.github.com/users/defunkt/subscriptions",
//        "organizations_url": "https://api.github.com/users/defunkt/orgs",
//        "repos_url": "https://api.github.com/users/defunkt/repos",
//        "events_url": "https://api.github.com/users/defunkt/events{/privacy}",
//        "received_events_url": "https://api.github.com/users/defunkt/received_events",
//        "type": "User",
//        "site_admin": true,
//        "name": "Chris Wanstrath",
//        "company": "@github ",
//        "blog": "http://chriswanstrath.com/",
//        "location": "San Francisco",
//        "email": null,
//        "hireable": null,
//        "bio": "🍔 ",
//        "public_repos": 107,
//        "public_gists": 273,
//        "followers": 20359,
//        "following": 210,
//        "created_at": "2007-10-20T05:24:19Z",
//        "updated_at": "2018-07-17T19:23:04Z"

    @SerializedName("avatar_url")
    @Expose
    private String avatar_url;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("bio")
    @Expose
    private String bio;

    @SerializedName("login")
    @Expose
    private String login;

    @SerializedName("site_admin")
    @Expose
    private Boolean site_admin;

    @SerializedName("location")
    @Expose
    private String location;

    @SerializedName("blog")
    @Expose
    private String blog;

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Boolean getSite_admin() {
        return site_admin;
    }

    public void setSite_admin(Boolean site_admin) {
        this.site_admin = site_admin;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }
}
