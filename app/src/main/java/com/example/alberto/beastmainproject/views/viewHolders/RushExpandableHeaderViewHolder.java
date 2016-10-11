package com.example.alberto.beastmainproject.views.viewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alberto.beastmainproject.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RushExpandableHeaderViewHolder  extends RecyclerView.ViewHolder {

    @BindView(R.id.list_expandable_header_buttonToggle)
    ImageView buttonToggle;

    @BindView(R.id.list_expandable_header_layout)
    public View backgroundView;

    @BindView(R.id.list_expandable_header_name)
    TextView headerName;

    public RushItem refferalItem;

    public RushExpandableHeaderViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void setHeaderNameText(String headerText) {
        headerName.setText(headerText);
    }

    public void toggleButtonImage(int imageResource) {
        buttonToggle.setImageResource(imageResource);
    }
}
