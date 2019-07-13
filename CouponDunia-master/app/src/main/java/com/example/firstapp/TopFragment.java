package com.example.firstapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class TopFragment extends Fragment {
    RecyclerView recyclerView;
    ArrayList<TopReciever> itemListCAt;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.top_recycle, container, false);
        recyclerView = (RecyclerView)rootView.findViewById(R.id.recyclerView2);
        setupRecyclerView(recyclerView);
        return rootView;
    }

    private void setupRecyclerView(RecyclerView recyclerView){
        itemListCAt = new ArrayList<TopReciever>();

        itemListCAt.add(new TopReciever(R.drawable.foodpanda,"Foodpanda", "47 Offers"));
        itemListCAt.add(new TopReciever(R.drawable.mylogo,"Delivery Guru", "23 Offers"));
        itemListCAt.add(new TopReciever(R.drawable.daraz,"Daraz.com", "10 Offers"));
        itemListCAt.add(new TopReciever(R.drawable.swiggy,"Swiggy", "7 Offers"));
        itemListCAt.add(new TopReciever(R.drawable.fish,"HealthCart", "11 Offers"));
        itemListCAt.add(new TopReciever(R.drawable.fish,"RobiShop", "24 Offers"));
        itemListCAt.add(new TopReciever(R.drawable.fish,"BagDoom", "5 Offers"));

        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(new TopAdapter(this,itemListCAt));
    }


}
