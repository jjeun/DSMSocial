package com.application.dsmsocial;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

/**
 * A placeholder fragment containing a simple view.
 */
public class AboutFragment extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";
    public static final String TAG = "AboutFragment";

    private int mPage;
    private ViewFlipper aViewFlipper;
    private TextView aboutTextView;
    private TextView aboutTitleView;
    private TextView aboutContactTitle;
    private TextView aboutContact1;
    private TextView aboutContact2;
    private TextView aboutContact3;
    private TextView aboutContact4;
    private TextView aboutContact5;

    int [] resources = {
            R.drawable.slideshow1,
            R.drawable.slideshow2,
            R.drawable.slideshow3,
            R.drawable.slideshow4
    };


    public static AboutFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        AboutFragment fragment = new AboutFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
    }

    // Inflate the fragment layout we defined above for this fragment
    // Set the associated text for the title
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View aboutView = inflater.inflate(R.layout.fragment_about, container, false);
        aViewFlipper = (ViewFlipper) aboutView.findViewById(R.id.aboutViewFlipper);
        aboutTextView = (TextView) aboutView.findViewById(R.id.aboutText);
        aboutTitleView = (TextView) aboutView.findViewById(R.id.aboutTitle);
        aboutContactTitle = (TextView) aboutView.findViewById(R.id.aboutContactTitle);
        aboutContact1 = (TextView) aboutView.findViewById(R.id.aboutContact1);
        aboutContact2 = (TextView) aboutView.findViewById(R.id.aboutContact2);
        aboutContact3 = (TextView) aboutView.findViewById(R.id.aboutContact3);
        aboutContact4 = (TextView) aboutView.findViewById(R.id.aboutContact4);
        aboutContact5 = (TextView) aboutView.findViewById(R.id.aboutContact5);
        //Add images to view flipper
        for (int resource : resources) {
            ImageView imageView = new ImageView(getActivity());
            imageView.setImageResource(resource);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            aViewFlipper.addView(imageView);
        }

        aViewFlipper.setAutoStart(true);
        aViewFlipper.setFlipInterval(3000); //flip image every 3 seconds

        aboutTextView.setText(getResources().getString(R.string.aboutText));
        aboutTitleView.setText(getResources().getString(R.string.aboutTitle));
        aboutContactTitle.setText(getResources().getString(R.string.aboutContactTitle));
        aboutContact1.setText(getResources().getString(R.string.aboutContact1));
        aboutContact2.setText(getResources().getString(R.string.aboutContact2));
        aboutContact3.setText(getResources().getString(R.string.aboutContact3));
        aboutContact4.setText(getResources().getString(R.string.aboutContact4));
        aboutContact5.setText(getResources().getString(R.string.aboutContact5));

        return aboutView;

    }
}


