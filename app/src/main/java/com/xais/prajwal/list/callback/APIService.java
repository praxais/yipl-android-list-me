package com.xais.prajwal.list.callback;

import com.xais.prajwal.list.pojo.CommentPojo;
import com.xais.prajwal.list.pojo.ListPojo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Prajwal on 2016-11-21.
 */

public interface APIService {

    @GET("posts")
    Call<List<ListPojo>> getAllList();

    @GET("posts/{id}/comments")
    Call<List<CommentPojo>> getIdComments(@Path("id") int id);

}
