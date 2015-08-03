package com.htech.restaurant.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.htech.restaurant.R;
import com.htech.restaurant.adapter.SubCategoryAdapter;
import com.htech.restaurant.vos.SubCategory;

import java.util.ArrayList;
import java.util.List;

public class MenuDetailActivity extends AppCompatActivity implements SubCategoryAdapter.OnItemClickListener{

    private Toolbar mToolbar;
    private String TAG = MenuDetailActivity.class.getSimpleName();
    private SubCategoryAdapter mAdapter;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_detail);
        mToolbar = (Toolbar) findViewById(R.id.menu_detail_toolbar);
       // setSupportActionBar(mToolbar);

        int menuId = getIntent().getIntExtra("MenuId",0);
        Log.d(TAG,"selected menu id:"+menuId);

        mRecyclerView = (RecyclerView) findViewById(R.id.activity_menu_detail_recyclerview);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        getSubMenuList();
    }
    /**
     * Fetch table list
     */
    private void getSubMenuList() {
        List<SubCategory> subCategories = new ArrayList<SubCategory>();

        for (int i = 0; i < 12; i++) {
            int id = (i + 1);
            SubCategory category = new SubCategory();
            category.setId(id);
            category.setSubCatName("" + id);
            subCategories.add(category);
        }
        mAdapter = new SubCategoryAdapter(this, subCategories, this);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onItemClickListener(int position) {
        Log.d(TAG,"add item:"+position);
    }
}
