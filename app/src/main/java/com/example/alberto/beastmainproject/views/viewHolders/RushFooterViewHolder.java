package com.example.alberto.beastmainproject.views.viewHolders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.alberto.beastmainproject.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RushFooterViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.footer_rush_fragment_twitter)
    ImageView twitterImage;

    @BindView(R.id.footer_rush_fragment_facebook)
    ImageView facebookImage;

    @BindView(R.id.footer_rush_fragment_snapchat)
    ImageView snapchatImage;

    @BindView(R.id.footer_rush_fragment_instagram)
    ImageView instagramImage;

    public RushFooterViewHolder(final View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);

        facebookImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent;
//                try {
//                    itemView.getContext().getPackageManager().getPackageInfo("com.facebook.katana", 0);
//                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse(""));
//                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                } catch (PackageManager.NameNotFoundException e) {
//                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse(""));
//                }
//
//                v.getContext().startActivity(intent);
            }
        });

        twitterImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent;
//                try {
//                    itemView.getContext().getPackageManager().getPackageInfo("com.twitter.android", 0);
//                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse(""));
//                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                } catch (PackageManager.NameNotFoundException e) {
//                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse(""));
//                }
//
//                v.getContext().startActivity(intent);
            }
        });

        snapchatImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(Intent.ACTION_VIEW,
//                        Uri.parse("http://snapchat.com/add/djkhaled"));
//
//                v.getContext().startActivity(intent);
            }
        });

        instagramImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent;
//                try {
//                    itemView.getContext().getPackageManager().getPackageInfo("com.instagram.android", 0);
//                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse(""));
//                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                } catch (PackageManager.NameNotFoundException e) {
//                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse(""));
//                }
//
//                v.getContext().startActivity(intent);
            }
        });
    }

    public void populate(Context context) {
        Picasso.with(context).load("http://orig12.deviantart.net/466a/f/2013/169/0/b/happy_shit_by_jasterm-d69luij.jpg")
                .fit()
                .centerInside()
                .into(facebookImage);

        Picasso.with(context).load("http://orig12.deviantart.net/466a/f/2013/169/0/b/happy_shit_by_jasterm-d69luij.jpg")
                .fit()
                .centerInside()
                .into(snapchatImage);

        Picasso.with(context).load("http://orig12.deviantart.net/466a/f/2013/169/0/b/happy_shit_by_jasterm-d69luij.jpg")
                .fit()
                .centerInside()
                .into(instagramImage);

        Picasso.with(context).load("http://orig12.deviantart.net/466a/f/2013/169/0/b/happy_shit_by_jasterm-d69luij.jpg")
                .fit()
                .centerInside()
                .into(twitterImage);
    }
}
