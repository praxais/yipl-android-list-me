package com.xais.prajwal.list.pojo;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

/**
 * Created by Prajwal on 2016-11-21.
 */

public class CommentPojo implements Serializable {

    @Expose
    private int postId;

    @Expose
    private int id;

    @Expose
    private String name;

    @Expose
    private String email;

    @Expose
    private String body;

    public CommentPojo(int postId, int id, String name, String email, String body) {
        this.postId = postId;
        this.id = id;
        this.name = name;
        this.email = email;
        this.body = body;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
