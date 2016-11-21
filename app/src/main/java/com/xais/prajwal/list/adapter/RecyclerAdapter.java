package com.xais.prajwal.list.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xais.prajwal.list.R;
import com.xais.prajwal.list.pojo.ListPojo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Prajwal on 2016-11-21.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {

    List<ListPojo> listPojo;

    public RecyclerAdapter() {
        listPojo = new ArrayList<>();
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items, parent, false);
        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(view);
        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        ListPojo currListPojo = listPojo.get(position);
        holder.userId.setText(Integer.toString(currListPojo.getUserId()));
        holder.id.setText(Integer.toString(currListPojo.getId()));
        holder.title.setText(currListPojo.getTitle());
        holder.body.setText(currListPojo.getBody());
    }

    @Override
    public int getItemCount() {
        return listPojo.size();
    }

    public void addData(ListPojo pojo) {
        listPojo.add(pojo);
        notifyDataSetChanged();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView userId, id, title, body;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            userId = (TextView) itemView.findViewById(R.id.txtUserId);
            id = (TextView) itemView.findViewById(R.id.txtId);
            title = (TextView) itemView.findViewById(R.id.txtTitle);
            body = (TextView) itemView.findViewById(R.id.txtBody);
        }

        @Override
        public void onClick(View view) {

        }
    }
}
