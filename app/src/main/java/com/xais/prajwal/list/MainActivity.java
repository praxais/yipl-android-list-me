package com.xais.prajwal.list;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.xais.prajwal.list.adapter.RecyclerAdapter;
import com.xais.prajwal.list.controller.RestManager;
import com.xais.prajwal.list.pojo.ListPojo;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements RecyclerAdapter.ListClickListner {

    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;
    RestManager restManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setHasFixedSize(true);
        recyclerView.setRecycledViewPool(new RecyclerView.RecycledViewPool());
        recyclerAdapter = new RecyclerAdapter(MainActivity.this);
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

        Toast.makeText(MainActivity.this, "" + id, Toast.LENGTH_SHORT).show();

    }
}
