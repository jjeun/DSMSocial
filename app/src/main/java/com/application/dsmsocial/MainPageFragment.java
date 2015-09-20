package com.application.dsmsocial;

import android.graphics.Color;
import android.graphics.Rect;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainPageFragment extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";
    public static final String TAG = "MainFragment";

    private ViewFlipper mViewFlipper;
    private ImageButton mainButton;
    private TextView mainTextView;
    int finalHeight;
    int finalWidth;

    int[] resources = {
            R.drawable.main_image1,
            R.drawable.main_image2,
            R.drawable.main_image3,
            R.drawable.main_image4,
            R.drawable.main_image5
    };

    public static MainPageFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        MainPageFragment fragment = new MainPageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    // Inflate the fragment layout we defined above for this fragment
    // Set the associated text for the title
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main_page, container, false);

        // Get the ViewFlipper
        mViewFlipper = (ViewFlipper) rootView.findViewById(R.id.mainViewFlipper);
        mainButton = (ImageButton) rootView.findViewById(R.id.imageButton);
        mainTextView = (TextView) rootView.findViewById(R.id.mainText);

        // Add all the images to the ViewFlipper
        for (int resource : resources) {
            ImageView imageView = new ImageView(getActivity());
            imageView.setImageResource(resource);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            mViewFlipper.addView(imageView);
        }

        mViewFlipper.setAutoStart(true);
        mViewFlipper.setFlipInterval(3000); //flip image every 3 seconds


        mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(TAG, "main clicked");   // Log's that Max button was pressed.
                // create method to activity
            }
        });



        final ViewTreeObserver vto = mainButton.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                mainButton.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                finalHeight = mainButton.getMeasuredHeight();
                finalWidth = mainButton.getMeasuredWidth();
                makeSpan();
            }
        });

        return rootView;

    }


    /**
     * This method builds the text layout
     */
    private void makeSpan() {

        /**
         * Get the text
         */
        String plainText=getResources().getString(R.string.mainText);
        Spanned htmlText = Html.fromHtml(plainText);
        SpannableString mSpannableString= new SpannableString(htmlText);


        int allTextStart = 0;
        int allTextEnd = htmlText.length() - 1;

        /**
         * Calculate the lines number = image height.
         * You can improve it... it is just an example
         */
        int lines;
        Rect bounds = new Rect();
        mainTextView.getPaint().getTextBounds(plainText.substring(0, 10), 0, 1, bounds);

        //float textLineHeight = mTextView.getPaint().getTextSize();
        float fontSpacing=mainTextView.getPaint().getFontSpacing();
        lines = (int) (finalHeight/fontSpacing);

        /**
         * Build the layout with LeadingMarginSpan2
         */
        MyLeadingMarginSpan2 span = new MyLeadingMarginSpan2(lines, finalWidth +10 );
        mSpannableString.setSpan(span, allTextStart, allTextEnd,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        mainTextView.setText(mSpannableString);
    }
}