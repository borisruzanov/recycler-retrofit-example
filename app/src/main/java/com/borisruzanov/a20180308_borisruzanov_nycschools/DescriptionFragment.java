package com.borisruzanov.a20180308_borisruzanov_nycschools;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Boris on 3/8/2018.
 */

public class DescriptionFragment extends Fragment {

    //Fragment which shows details of clicked school from the list

    View view;
    public static String READING_SCORE = "reading";
    public static String WRITING_SCORE = "writing";
    public static String MATH_SCORE = "math";

    public DescriptionFragment getInstance(String readingScore, String writingScore, String matchScore){
        DescriptionFragment fragment = new DescriptionFragment();
        Bundle bundle = new Bundle();
        bundle.putString(READING_SCORE, readingScore);
        bundle.putString(WRITING_SCORE, writingScore);
        bundle.putString(MATH_SCORE, matchScore);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Inflating view
        view = inflater.inflate(R.layout.school_description, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        TextView tvReading = view.findViewById(R.id.item_tv_reading_score);
        TextView tvWriting = view.findViewById(R.id.item_tv_writing_score);
        TextView tvMath = view.findViewById(R.id.item_tv_math_score);

        //Set text views with needed info
        tvReading.setText(getScore(READING_SCORE));
        tvWriting.setText(getScore(WRITING_SCORE));
        tvMath.setText(getScore(MATH_SCORE));
    }

    public String getScore(String scoreName){
        //Checking Data for null
        if(getArguments().getString(scoreName) != null){
            return getArguments().getString(scoreName);
        } else {
            return getString(R.string.error);
        }
    }



}
