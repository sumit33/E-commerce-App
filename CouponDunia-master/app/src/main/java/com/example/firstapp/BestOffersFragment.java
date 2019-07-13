package com.example.firstapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class BestOffersFragment extends Fragment {
    RecyclerView recyclerView;

    ArrayList<BestItemReciever>itemList;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.best_recycle, container, false);
        recyclerView = rootView.findViewById(R.id.recyclerView1);
        setupRecyclerView(recyclerView);
        return rootView;

    }

    private void setupRecyclerView(RecyclerView recyclerView){

        itemList = new ArrayList<>();

        itemList.add(new BestItemReciever(R.drawable.foodpanda,"Foodpanda", "Food Delivery ", "Mega Offer!! Upto 35% off in this Summer", "Upto 21% CD cashback!!"));
        itemList.add(new BestItemReciever(R.drawable.mylogo,"Delivery Guru", "Delivers Anything", "The simplest way to get your goods", "Upto 21% CD cashback!!"));
        itemList.add(new BestItemReciever(R.drawable.daraz,"Daraz.com", "Online Market", "We recommend you this.", "Upto 21% CD cashback!!"));
        itemList.add(new BestItemReciever(R.drawable.swiggy,"Swiggy", "Food Delivery", "We recommend you this.", "Upto 21% CD cashback!!"));
        itemList.add(new BestItemReciever(R.drawable.fish,"HealthCart", "Health & Beauty", "We recommend you this.", "Upto 21% CD cashback!!"));
        itemList.add(new BestItemReciever(R.drawable.fish,"Foodpanda", "Food", "We recommend you this.", "Upto 21% CD cashback!!"));
        itemList.add(new BestItemReciever(R.drawable.fish,"Foodpanda", "Food", "We recommend you this.", "Upto 21% CD cashback!!"));

        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(new BestOffersAdapter(getContext(),itemList));


    }
}
