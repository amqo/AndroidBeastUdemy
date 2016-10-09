package com.example.alberto.beastmainproject.views.adapters;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alberto.beastmainproject.R;
import com.example.alberto.beastmainproject.activities.BaseActivity;
import com.example.alberto.beastmainproject.entities.Brother;
import com.example.alberto.beastmainproject.views.viewHolders.MeetABroViewHolder;

import java.util.ArrayList;

public class MeetABroAdapter extends RecyclerView.Adapter<MeetABroViewHolder> implements View.OnClickListener {

    private LayoutInflater inflater;
    private BaseActivity activity;

    private OnBrotherClickListener listener;
    private ArrayList<Brother> brothers;

    public MeetABroAdapter(OnBrotherClickListener listener, BaseActivity activity) {
        this.listener = listener;
        this.activity = activity;

        inflater = activity.getLayoutInflater();
        brothers = new ArrayList<>();
    }

    public void setBrothers(ArrayList<Brother> brothers) {
        this.brothers = brothers;
    }

    @Override
    public MeetABroViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View listElementView = inflater.inflate(R.layout.list_element_meet_a_bro, parent, false);
        listElementView.setOnClickListener(this);
        return new MeetABroViewHolder(listElementView);
    }

    @Override
    public void onBindViewHolder(MeetABroViewHolder holder, int position) {
        holder.populate(activity, brothers.get(position));
    }

    @Override
    public int getItemCount() {
        return brothers.size();
    }

    @Override
    public void onClick(View view) {
        if (view.getTag() instanceof Brother) {
            Brother brother = (Brother) view.getTag();
            listener.onBrotherClicked(brother);
        }
    }

    public interface OnBrotherClickListener {
        void onBrotherClicked(Brother brother);
    }
}
