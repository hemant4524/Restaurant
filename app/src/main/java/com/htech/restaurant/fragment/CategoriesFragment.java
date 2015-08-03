package com.htech.restaurant.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.htech.restaurant.R;
import com.htech.restaurant.activity.MenuDetailActivity;
import com.htech.restaurant.adapter.CategoryAdapter;
import com.htech.restaurant.vos.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoriesFragment extends Fragment implements CategoryAdapter.OnItemClickListener {

    private CategoryAdapter mAdapter;

    private RecyclerView mRecyclerView;

    private String TAG = CategoriesFragment.class.getSimpleName();

    public CategoriesFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_categories, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.fragment_category_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
       // mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3)); // Grid view
        // Set dynamic table list
        getMainMenu();

        return view;
    }

    /**
     * Fetch table list
     */
    private void getMainMenu() {
        List<Category> categories = new ArrayList<Category>();

        for (int i = 0; i < 12; i++) {
            int id = (i + 1);
            Category category = new Category();
            category.setId(id);
            category.setCatName("" + id);
            categories.add(category);
        }
        mAdapter = new CategoryAdapter(getActivity(), categories, this);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onItemClickListener(int menuid) {
        Intent intent = new Intent(getActivity(), MenuDetailActivity.class);
        intent.putExtra("MenuId",menuid);
        startActivity(intent);
    }
}
