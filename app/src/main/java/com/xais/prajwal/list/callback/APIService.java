package com.xais.prajwal.list.callback;

import com.xais.prajwal.list.pojo.ListPojo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Prajwal on 2016-11-21.
 */

public interface APIService {

    @GET("posts")
    Call<List<ListPojo>> getAllList();

}
