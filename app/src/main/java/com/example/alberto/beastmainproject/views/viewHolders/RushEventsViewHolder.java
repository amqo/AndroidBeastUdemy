package com.example.alberto.beastmainproject.views.viewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.alberto.beastmainproject.R;
import com.example.alberto.beastmainproject.entities.RushEvent;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RushEventsViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.list_rush_event_name)
    TextView rushName;

    @BindView(R.id.list_rush_event_date)
    TextView rushDate;

    @BindView(R.id.list_rush_event_location)
    TextView rushLocation;

    @BindView(R.id.list_rush_event_time)
    TextView rushTime;

    public RushEventsViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void populate(RushEvent rushEvent) {
        itemView.setTag(rushEvent);

        rushName.setText(rushEvent.getEventName());
        rushDate.setText(rushEvent.getEventDate());
        rushTime.setText(rushEvent.getEventTime());
        rushLocation.setText(rushEvent.getEventLocation());
    }
}
