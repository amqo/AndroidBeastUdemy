package com.example.alberto.beastmainproject.views.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alberto.beastmainproject.R;
import com.example.alberto.beastmainproject.activities.BaseActivity;
import com.example.alberto.beastmainproject.entities.EventCard;
import com.example.alberto.beastmainproject.views.viewHolders.AboutUsListElementHeaderViewHolder;
import com.example.alberto.beastmainproject.views.viewHolders.AboutUsMainHeaderViewHolder;
import com.example.alberto.beastmainproject.views.viewHolders.BrotherHoodViewHolder;
import com.example.alberto.beastmainproject.views.viewHolders.CommunityServiceViewHolder;
import com.example.alberto.beastmainproject.views.viewHolders.SocialViewHolder;

import java.util.ArrayList;

///> Main Header <///

///> List Header <///
///>Community List <///

///> List Header <///
///>BrotherHood List <///

///> List Header <///
///>Social List <///

public class AboutUsAdapter extends RecyclerView.Adapter {

    private final int VIEW_TYPE_MAIN_HEADER = 1;
    private final int VIEW_TYPE_SERVICE_LIST = 2;
    private final int VIEW_TYPE_BROTHERHOOD_LIST = 3;
    private final int VIEW_TYPE_SOCIAL_LIST = 4;
    private final int VIEW_TYPE_LIST_HEADER = 5;

    private LayoutInflater inflater;
    private BaseActivity activity;

    private ArrayList<EventCard> communityServiceEventCards;
    private ArrayList<EventCard> brotherHoodEventCards;
    private ArrayList<EventCard> socialEventCards;

    private AboutUsListener listener;

    public AboutUsAdapter(AboutUsListener listener, BaseActivity activity) {
        this.listener = listener;
        this.activity = activity;

        inflater = activity.getLayoutInflater();
        communityServiceEventCards = new ArrayList<>();
        brotherHoodEventCards = new ArrayList<>();
        socialEventCards = new ArrayList<>();
    }

    public void setCommunityServiceEventCards(ArrayList<EventCard> communityServiceEventCards) {
        this.communityServiceEventCards = communityServiceEventCards;
    }

    public void setBrotherHoodEventCards(ArrayList<EventCard> brotherHoodEventCards) {
        this.brotherHoodEventCards = brotherHoodEventCards;
    }

    public void setSocialEventCards(ArrayList<EventCard> socialEventCards) {
        this.socialEventCards = socialEventCards;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View listEventCard = inflater.inflate(R.layout.list_element_event_card, parent, false);
        switch (viewType) {
            case VIEW_TYPE_MAIN_HEADER:
                return new AboutUsMainHeaderViewHolder(inflater, parent);
            case VIEW_TYPE_LIST_HEADER:
                View itemView = inflater.inflate(R.layout.simple_header, parent, false);
                return new AboutUsListElementHeaderViewHolder(itemView);
            case VIEW_TYPE_BROTHERHOOD_LIST:
                final BrotherHoodViewHolder brotherHoodViewHolder = new BrotherHoodViewHolder(listEventCard);
                brotherHoodViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        EventCard eventCard = (EventCard) brotherHoodViewHolder.itemView.getTag();
                        listener.OnEventCardClicked(eventCard);
                    }
                });
                return brotherHoodViewHolder;
            case VIEW_TYPE_SERVICE_LIST:
                final CommunityServiceViewHolder communityServiceViewHolder = new CommunityServiceViewHolder(listEventCard);
                communityServiceViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        EventCard eventCard = (EventCard) communityServiceViewHolder.itemView.getTag();
                        listener.OnEventCardClicked(eventCard);
                    }
                });
                return communityServiceViewHolder;
            case VIEW_TYPE_SOCIAL_LIST:
                final SocialViewHolder socialViewHolder = new SocialViewHolder(listEventCard);
                socialViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        EventCard eventCard = (EventCard) socialViewHolder.itemView.getTag();
                        listener.OnEventCardClicked(eventCard);
                    }
                });
                return socialViewHolder;
            default:
                throw new IllegalArgumentException(viewType + " is not supported in this adapter.");
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0)  return VIEW_TYPE_MAIN_HEADER;
        position--;

        if (!communityServiceEventCards.isEmpty()) {
            if (position == 0) return VIEW_TYPE_LIST_HEADER;
            position--;

            if (position < communityServiceEventCards.size()) return VIEW_TYPE_SERVICE_LIST;
            position -= communityServiceEventCards.size();
        }

        if (!brotherHoodEventCards.isEmpty()) {
            if (position == 0) return VIEW_TYPE_LIST_HEADER;
            position--;

            if (position < brotherHoodEventCards.size()) return VIEW_TYPE_BROTHERHOOD_LIST;
            position -= brotherHoodEventCards.size();
        }

        if (!socialEventCards.isEmpty()) {
            if (position == 0) return VIEW_TYPE_LIST_HEADER;
            position--;

            if (position < socialEventCards.size()) return VIEW_TYPE_SOCIAL_LIST;
            position -= socialEventCards.size();
        }

        throw new IllegalArgumentException("Incorrect position for array index at " + position);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (position == 0) return;

        position--;

        if (!communityServiceEventCards.isEmpty()) {
            if (position == 0) {
                ((AboutUsListElementHeaderViewHolder) holder).populate("Community Service Events");
                return;
            }
            position--;

            if (position < communityServiceEventCards.size()) {
                ((CommunityServiceViewHolder) holder).populate(activity, communityServiceEventCards.get(position));
                return;
            }
            position -= communityServiceEventCards.size();
        }

        if (!brotherHoodEventCards.isEmpty()) {
            if (position == 0) {
                ((AboutUsListElementHeaderViewHolder) holder).populate("BrotherHood Events");
                return;
            }
            position--;

            if (position < brotherHoodEventCards.size()) {
                ((BrotherHoodViewHolder) holder).populate(activity, brotherHoodEventCards.get(position));
                return;
            }
            position -= brotherHoodEventCards.size();
        }

        if (!socialEventCards.isEmpty()) {
            if (position == 0) {
                ((AboutUsListElementHeaderViewHolder) holder).populate("Social Events");
                return;
            }
            position--;

            if (position < socialEventCards.size()) {
                ((SocialViewHolder) holder).populate(activity, socialEventCards.get(position));
                return;
            }
            position -= socialEventCards.size();
        }

        throw new IllegalArgumentException("Incorrect position for array index at " + position);
    }

    @Override
    public int getItemCount() {
        return 1 +
                (communityServiceEventCards.isEmpty() ?
                        0 : 1 + communityServiceEventCards.size()) +
                (brotherHoodEventCards.isEmpty() ?
                        0 : 1 + brotherHoodEventCards.size()) +
                (socialEventCards.isEmpty() ?
                        0 : 1 + socialEventCards.size());
    }

    public interface AboutUsListener {
        void OnEventCardClicked(EventCard eventCard);
    }
}
