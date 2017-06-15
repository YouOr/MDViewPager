package com.Liufeng.MyViewPager;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.Liufeng.MyViewPager.adapter.FindAdapter;
import com.Liufeng.MyViewPager.model.Fruit;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Administrator on 2017/5/23.
 */

public class MainFindFragment extends Fragment {
    private Fruit[] fruits = {new Fruit("Apple", R.drawable.apple512), new Fruit("lemon", R.drawable.lemon512), new Fruit("pear", R.drawable.pear512)
            , new Fruit("tomato", R.drawable.tomato512), new Fruit("apricot", R.drawable.apricot512), new Fruit("mango", R.drawable.mango512), new Fruit("orange", R.drawable.orange512)
            , new Fruit("kiwi", R.drawable.kiwi512), new Fruit("cherry", R.drawable.cherry512), new Fruit("banana", R.drawable.banana512), new Fruit("strawberry", R.drawable.strawberry512), new Fruit("peach", R.drawable.peach512)};
    private List<Fruit> fruitList = new ArrayList<>();
    private FindAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_find, container, false);
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.fruit_Rv);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new FindAdapter(fruitList);
        recyclerView.setAdapter(adapter);
        initFruits();
        adapter.setOnItemClickListener(new FindAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View View, int position) {
                Toast.makeText(getActivity(),"点击了"+fruitList.get(position).getName(),Toast.LENGTH_SHORT).show();
            }
        });
        return rootView;
    }

    private void initFruits() {
        fruitList.clear();
        for (int i = 0; i < 51; i++) {
            Random random = new Random();
            int index = random.nextInt(fruits.length);
            fruitList.add(fruits[index]);
        }
    }



}
