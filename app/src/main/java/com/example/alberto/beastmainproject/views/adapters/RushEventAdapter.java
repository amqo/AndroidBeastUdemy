package com.example.alberto.beastmainproject.views.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alberto.beastmainproject.R;
import com.example.alberto.beastmainproject.activities.BaseActivity;
import com.example.alberto.beastmainproject.entities.RushEvent;
import com.example.alberto.beastmainproject.views.viewHolders.RushEventsViewHolder;
import com.example.alberto.beastmainproject.views.viewHolders.RushExpandableHeaderViewHolder;
import com.example.alberto.beastmainproject.views.viewHolders.RushFooterViewHolder;
import com.example.alberto.beastmainproject.views.viewHolders.RushHeaderViewHolder;
import com.example.alberto.beastmainproject.views.viewHolders.RushItem;

import java.util.ArrayList;
import java.util.List;

public class RushEventAdapter extends RecyclerView.Adapter {

    private final int VIEW_TYPE_LIST_HEADER = 0;
    public static final int VIEW_TYPE_EXPANDABLE_LIST_HEADER = 1;
    public static final int VIEW_TYPE_EXPANDABLE_LIST_CHILD = 2;
    private final int VIEW_TYPE_LIST_FOOTER = 3;

    private List<RushItem> data;
    private BaseActivity activity;
    private LayoutInflater layoutInflater;

    private RushEventListener listener;

    public RushEventAdapter(BaseActivity activity, RushEventListener listener) {
        this.activity = activity;
        this.listener = listener;

        layoutInflater = activity.getLayoutInflater();
        data = new ArrayList<>();
    }

    public List<RushItem> getData() {
        return data;
    }

    //> Header <//
    //> List <//
    //> Footer <//

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return VIEW_TYPE_LIST_HEADER;
        }
        position--;

        if (position < data.size()) {
            return data.get(position).type;
        }
        position -= data.size();

        if (position < data.size()) {
            return VIEW_TYPE_LIST_FOOTER;
        }
        position--;

        throw new IllegalArgumentException("Incorrect position for array index at " + position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View expandableHeaderView = layoutInflater.inflate(R.layout.list_expandable_header, parent, false);
        View rushEventView = layoutInflater.inflate(R.layout.list_rush_event, parent, false);
        View rushHeaderView = layoutInflater.inflate(R.layout.header_fragment_rush, parent, false);
        View rushFooterView = layoutInflater.inflate(R.layout.list_footer_rush_fragment, parent, false);

        switch(viewType) {
            case VIEW_TYPE_LIST_HEADER:
                return new RushHeaderViewHolder(rushHeaderView);
            case VIEW_TYPE_EXPANDABLE_LIST_HEADER:
                return new RushExpandableHeaderViewHolder(expandableHeaderView);
            case VIEW_TYPE_EXPANDABLE_LIST_CHILD:
                final RushEventsViewHolder holder = new RushEventsViewHolder(rushEventView);
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        RushEvent rushEvent = (RushEvent) holder.itemView.getTag();
                        listener.onRushEventClicked(rushEvent);
                    }
                });
                return holder;
            case VIEW_TYPE_LIST_FOOTER:
                return new RushFooterViewHolder(rushFooterView);
            default:
                throw new IllegalArgumentException(viewType + " is not supported in this adapter.");
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof  RushExpandableHeaderViewHolder) {
            position--;

            final RushItem rushItem = data.get(position);
            final RushExpandableHeaderViewHolder itemController = (RushExpandableHeaderViewHolder) holder;

            itemController.refferalItem = rushItem;
            itemController.setHeaderNameText(rushItem.header);

            if (rushItem.isExpanded()) {
                itemController.toggleButtonImage(R.mipmap.close);
            } else {
                itemController.toggleButtonImage(R.mipmap.plus);
            }

            itemController.backgroundView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (rushItem.isExpanded()) {
                        rushItem.invisibleChildren = new ArrayList<>();
                        int count = 0;
                        int position = data.indexOf(itemController.refferalItem);

                        while(data.size() > position + 1 &&
                                data.get(position + 1).type == VIEW_TYPE_EXPANDABLE_LIST_CHILD) {
                            rushItem.invisibleChildren.add(data.remove(position + 1));
                            count++;
                        }

                        notifyItemRangeRemoved(position + 1, count);
                        itemController.toggleButtonImage(R.mipmap.plus);
                    } else {
                        int position = data.indexOf(itemController.refferalItem);
                        int index = position + 1;

                        for (RushItem item: rushItem.invisibleChildren) {
                            data.add(index, item);
                            index++;
                        }

                        notifyItemRangeChanged(position + 1, index - position - 1);
                        itemController.toggleButtonImage(R.mipmap.close);
                        rushItem.invisibleChildren = null;
                    }
                }
            });
        } else if (holder instanceof RushEventsViewHolder) {
            position--;
            RushEventsViewHolder rushEventsViewHolder = (RushEventsViewHolder) holder;
            rushEventsViewHolder.populate(data.get(position).rushEvent);
        } else if (holder instanceof  RushHeaderViewHolder) {
            position--;
            //RushHeaderViewHolder rushHeaderViewHolder = (RushHeaderViewHolder) holder;
        } else if (holder instanceof RushFooterViewHolder) {
            ((RushFooterViewHolder) holder).populate(activity);
        }
    }

    @Override
    public int getItemCount() {
        int count = 2;
        if (!data.isEmpty()) {
            count += data.size();
        }
        return count;
    }

    public interface RushEventListener {
        void onRushEventClicked(RushEvent rushEvent);
    }
}
