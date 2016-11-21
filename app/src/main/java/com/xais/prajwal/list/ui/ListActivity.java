package com.xais.prajwal.list.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.xais.prajwal.list.R;
import com.xais.prajwal.list.adapter.RecyclerAdapter;
import com.xais.prajwal.list.controller.RestManager;
import com.xais.prajwal.list.pojo.ListPojo;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListActivity extends AppCompatActivity implements RecyclerAdapter.ListClickListner {

    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;
    RestManager restManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setHasFixedSize(true);
        recyclerView.setRecycledViewPool(new RecyclerView.RecycledViewPool());
        recyclerAdapter = new RecyclerAdapter(ListActivity.this);
        recyclerView.setAdapter(recyclerAdapter);

        restManager = new RestManager();

        Call<List<ListPojo>> listCall = restManager.getApiService().getAllList();

        listCall.enqueue(new Callback<List<ListPojo>>() {
            @Override
            public void onResponse(Call<List<ListPojo>> call, Response<List<ListPojo>> response) {

                if (response.isSuccessful()) {

                    List<ListPojo> listPojo = response.body();

                    for (int i = 0; i < listPojo.size(); i++) {
                        ListPojo pojo = listPojo.get(i);
                        recyclerAdapter.addData(pojo);
                    }

                }
            }

            @Override
            public void onFailure(Call<List<ListPojo>> call, Throwable t) {

            }
        });
    }

    @Override
    public void onClick(int position) {

        ListPojo selectedListPojo = recyclerAdapter.getSelectedList(position);

        int id = selectedListPojo.getId();

        /*Toast.makeText(ListActivity.this, "Position id is " + id, Toast.LENGTH_SHORT).show();*/

        Intent intent = new Intent(ListActivity.this, CommentActivity.class);
        intent.putExtra("Id", id);
        startActivity(intent);


    }
}
