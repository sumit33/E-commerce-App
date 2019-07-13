package com.example.firstapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class TopAdapter extends RecyclerView.Adapter<TopAdapter.ViewHolder>{
    private TopFragment mContext;
    private ArrayList<TopReciever> mlist;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public final View mView;
        public final TextView textView1, textView2;
        ImageView imageView1;

        public ViewHolder(View view) {
            super(view);
            mView = view;



            textView1 = view.findViewById(R.id.catName);
            textView2 = view.findViewById(R.id.catCount);
            imageView1 = view.findViewById(R.id.catImg);

        }

    }


    public TopAdapter(TopFragment context, ArrayList<TopReciever> list) {
        mContext = context;
        mlist = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.top_model_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "You clicked " + getValueAt(position).textView1, Toast.LENGTH_SHORT).show();
            }
        });
        ImageView image1;
        TextView text1, text2, text3;

        TopReciever itemReciever;

        itemReciever = mlist.get(position);

        image1 = holder.imageView1;
        text1 = holder.textView1;
        text2 = holder.textView2;


        image1.setImageResource(itemReciever.getImageView1());


        text1.setText(itemReciever.getTextView1());
        text2.setText(itemReciever.getTextView2());
    }
    public TopReciever getValueAt(int position) {
        return mlist.get(position);
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }
}