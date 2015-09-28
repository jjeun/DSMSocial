package com.application.dsmsocial;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class ShopFragment extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";
    private static final String TAG = "ShopFragementTag";
    String name;
    String type;
    Bitmap image;
    int page;


    private GridView gridView;
    private GridViewAdapter gridAdapter;

    public static ShopFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        ShopFragment fragment = new ShopFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        name = getActivity().getIntent().getStringExtra("name");
        type = getActivity().getIntent().getStringExtra("type");
        image = getActivity().getIntent().getParcelableExtra("image");
        page = getActivity().getIntent().getIntExtra("switch", 0);
    }



    // Prepare some dummy data for shopGridview
    private ArrayList<ImageItem> getData() {
        final ArrayList<ImageItem> imageItems = new ArrayList<>();
        TypedArray imgs = getResources().obtainTypedArray(R.array.shopImage);
        TypedArray name = getResources().obtainTypedArray(R.array.shopName);
        TypedArray price = getResources().obtainTypedArray(R.array.shopPrice);
        TypedArray media = getResources().obtainTypedArray(R.array.shopMedia);
        for (int i = 0; i < imgs.length(); i++) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), imgs.getResourceId(i, -1));
            imageItems.add(new ImageItem(bitmap,null, name.getString(i), media.getString(i), price.getString(i)));
        }
        return imageItems;
    }



    // Inflate the fragment layout we defined above for this fragment
    // Set the associated text for the title
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_shop, container, false);

        gridView = (GridView) rootView.findViewById(R.id.shopGridView);
        gridAdapter = new GridViewAdapter(getActivity(), R.layout.grid_item_layout, getData());
        gridView.setAdapter(gridAdapter);

        SearchView searchView;
        searchView = (SearchView) rootView.findViewById(R.id.shopSearchView);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                gridAdapter.filter(query, 1);
                return false;
            }
        });

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Log.v(TAG, "shop clicked");
                ImageItem item = (ImageItem) gridView.getItemAtPosition(position);

                Intent intent = new Intent(getActivity(), ShopActivity.class);
                intent.putExtra("title", item.getTitle());
                intent.putExtra("image", item.getImage());
                intent.putExtra("name", item.getName());
                startActivity(intent);
            }
        });


        ImageButton mButton = (ImageButton) rootView.findViewById(R.id.shopCartButton);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(TAG, "shopping cart view button");
                sendToCart();
            }
        });

        return rootView;
    }


    public void sendToCart(){

        if(name == null){
            Toast.makeText(getActivity(), "Empty Shopping Cart", Toast.LENGTH_SHORT).show();
        }

        else{
            Intent intent = new Intent(getActivity(), CartReview.class);
            intent.putExtra("image", image);
            intent.putExtra("name", name);
            startActivity(intent);
        }
    }
}
