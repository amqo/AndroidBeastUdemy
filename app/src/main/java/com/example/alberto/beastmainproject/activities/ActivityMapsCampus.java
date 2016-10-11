package com.example.alberto.beastmainproject.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.alberto.beastmainproject.R;
import com.example.alberto.beastmainproject.entities.RushEvent;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ActivityMapsCampus extends BaseActivity {

    @BindView(R.id.activity_map_rush_name)
    TextView rushName;

    @BindView(R.id.activity_map_rush_date)
    TextView rushDate;

    @BindView(R.id.activity_map_rush_time)
    TextView rushTime;

    @BindView(R.id.activity_map_rush_location)
    TextView rushLocation;

    @BindView(R.id.activity_map_rush_description)
    TextView rushDescription;

    @BindView(R.id.fragment_campus_map_webView)
    WebView campusWebView;

    @BindView(R.id.activity_campus_map_progressBar)
    ProgressBar progressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campus_map);
        ButterKnife.bind(this);
        RushEvent rushEvent = getIntent().getParcelableExtra(ActivityMaps.RUSH_EVENT_INFO);

        rushName.setText(rushEvent.getEventName());
        rushDate.setText(rushEvent.getEventDate());
        rushTime.setText(rushEvent.getEventTime());
        rushLocation.setText(rushEvent.getEventLocation());
        rushDescription.setText(rushEvent.getEventDescription());

        String googleDocs = "http://docs.google.com/gview?embedded=true&url=";

        progressBar.setMax(100);
        campusWebView.getSettings().setJavaScriptEnabled(true);
        campusWebView.getSettings().setBuiltInZoomControls(true);
        campusWebView.getSettings().setSupportZoom(true);

        campusWebView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if (newProgress == 100) {
                    progressBar.setVisibility(View.GONE);
                } else {
                    progressBar.setVisibility(View.VISIBLE);
                    progressBar.setProgress(newProgress);
                }
            }
        });

        campusWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return false;
            }
        });

        campusWebView.loadUrl(googleDocs + "http://www.asu.edu/map/pdf/asu_map_tempe_2015.pdf");
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && campusWebView.canGoBack()) {
            campusWebView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    public static Intent newIntent(Context context,RushEvent rushEvent) {
        Intent intent = new Intent(context, ActivityMapsCampus.class);
        intent.putExtra(ActivityMaps.RUSH_EVENT_INFO, rushEvent);
        return intent;
    }
}
