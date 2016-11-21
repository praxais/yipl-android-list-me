package com.xais.prajwal.list.pojo;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

/**
 * Created by Prajwal on 2016-11-21.
 */

public class ListPojo implements Serializable {

    @Expose
    private int userId;

    @Expose
    private int id;

    @Expose
    private String title;

    @Expose
    private String body;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
