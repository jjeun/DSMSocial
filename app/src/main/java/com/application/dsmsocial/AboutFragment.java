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

    int [] resources = {
            R.drawable.vgallery_about,
            R.drawable.vgallery_about2
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

        //Add images to view flipper
        for (int resource : resources) {
            ImageView imageView = new ImageView(getActivity());
            imageView.setImageResource(resource);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            aViewFlipper.addView(imageView);
        }

        aViewFlipper.setAutoStart(true);
        aViewFlipper.setFlipInterval(3000); //flip image every 3 seconds

        return aboutView;

    }
}


