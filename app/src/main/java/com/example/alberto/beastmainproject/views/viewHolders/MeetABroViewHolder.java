package com.example.alberto.beastmainproject.views.viewHolders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.alberto.beastmainproject.R;
import com.example.alberto.beastmainproject.entities.Brother;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MeetABroViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.list_meet_a_bro_ImageView)
    ImageView brotherPicture;

    @BindView(R.id.list_meet_a_bro_ProgressBar)
    ProgressBar brotherProgressBar;

    public MeetABroViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void populate(Context context, Brother brother) {
        itemView.setTag(brother);

        Picasso.with(context).load(brother.getBrotherPicture())
                .fit()
                .centerCrop()
                .into(brotherPicture, new Callback() {
                    @Override
                    public void onSuccess() {
                        brotherProgressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError() {

                    }
                });
    }
}
