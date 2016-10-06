package com.example.alberto.beastmainproject.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.alberto.beastmainproject.R;
import com.example.alberto.beastmainproject.activities.PracticeActivity;
import com.example.alberto.beastmainproject.entities.Brother;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BrotherDetailFragment extends BaseFragment {

    @BindView(R.id.fragment_brother_detail_brotherCrossed)
    TextView brotherCrossed;

    @BindView(R.id.fragment_brother_detail_brotherName)
    TextView brotherName;

    @BindView(R.id.fragment_brother_detail_brotherMajor)
    TextView brotherMajor;

    @BindView(R.id.fragment_brother_detail_brotherFunFact)
    TextView brotherFunFact;

    @BindView(R.id.fragment_brother_detail_brotherWhyJoined)
    TextView brotherWhyJoined;

    @BindView(R.id.fragment_brother_detail_progressBar)
    ProgressBar brotherProgressBar;

    @BindView(R.id.fragment_brother_detail_brotherPircture)
    ImageView brotherPicture;

    private Brother brother;

    public static BrotherDetailFragment newInstance(Brother brother) {
        Bundle arguments = new Bundle();
        arguments.putParcelable(PracticeActivity.BROTHER_EXTRA_INFO, brother);
        BrotherDetailFragment fragment = new BrotherDetailFragment();
        fragment.setArguments(arguments);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        brother = getArguments().getParcelable(PracticeActivity.BROTHER_EXTRA_INFO);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_brother_details, container, false);

        ButterKnife.bind(this, rootView);

        brotherName.setText(brother.getBrotherName());
        brotherMajor.setText(getString(R.string.major_intro, brother.getBrotherMajor()));
        brotherFunFact.setText(getString(R.string.fun_fact, brother.getBrotherFunFact()));
        brotherCrossed.setText(getString(R.string.crossed_semester_intro, brother.getBrotherCrossSemester()));
        brotherWhyJoined.setText(brother.getBrotherWhyJoin());

        Picasso.with(getActivity()).load(brother.getBrotherPicture())
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

        return rootView;
    }
}
