package com.example.alberto.beastmainproject.views.viewHolders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.alberto.beastmainproject.R;
import com.example.alberto.beastmainproject.entities.EventCard;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CommunityServiceViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.list_event_card_eventDescription)
    TextView eventDescription;

    @BindView(R.id.list_event_card_eventName)
    TextView eventName;

    @BindView(R.id.list_event_card_progressBar)
    ProgressBar progressBar;

    @BindView(R.id.list_event_card_imageView)
    ImageView eventImage;

    @BindView(R.id.list_event_card_eventType)
    ImageView eventType;

    public CommunityServiceViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void populate(Context context, EventCard eventCard) {
        itemView.setTag(eventCard);

        if (!eventCard.isVideo()) {
            eventType.setImageResource(R.mipmap.camera);
        } else {
            eventType.setImageResource(R.mipmap.video);
        }

        eventDescription.setText(eventCard.getEventDescription());
        eventName.setText(eventCard.getEventName());

        Picasso.with(context).setLoggingEnabled(true);

        Picasso.with(context).load(eventCard.getEventImage())
        //Picasso.with(context).load(eventCard.getEventImage())
            .fit()
            .centerCrop()
            .into(eventImage, new Callback() {
                @Override
                public void onSuccess() {
                    progressBar.setVisibility(View.GONE);
                }

                @Override
                public void onError() {
                    Log.e(CommunityServiceViewHolder.class.getSimpleName(), "Error loading image");
                }
            });
    }
}
