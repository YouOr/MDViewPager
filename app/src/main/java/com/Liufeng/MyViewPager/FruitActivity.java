package com.Liufeng.MyViewPager;


import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

import com.bumptech.glide.Glide;

/**
 * Created by Administrator on 2017/6/1.
 */
public class FruitActivity extends AppCompatActivity {
    private static final String fruitName = "";
    private static final String fruitImageID = "";
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_fruit_info);
        toolbar = (Toolbar) findViewById(R.id.toolBar);
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        ImageView fruit_image_view = (ImageView) findViewById(R.id.fruit_image_view);
        TextView fruit_content_text = (TextView) findViewById(R.id.fruit_content_text);
        toolbar.setTitle("六一");
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            toolbar.setTitleTextColor(getResources().getColor(R.color.textColorPrimary));
        }
        Glide.with(this).load(R.drawable.luy).into(fruit_image_view);
        fruit_content_text.setText(getFruitInfo());
    }
    private String getFruitInfo(){
        StringBuilder fruitContent=new StringBuilder();
        for (int i=0;i<=500;i++){
            fruitContent.append("水果");
        }
        return fruitContent.toString();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
