package com.example.alberto.beastmainproject.views.viewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.alberto.beastmainproject.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AboutUsListElementHeaderViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.simple_header_textView)
    TextView headerText;

    public AboutUsListElementHeaderViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void populate(String header) {
        headerText.setText(header);
    }
}
