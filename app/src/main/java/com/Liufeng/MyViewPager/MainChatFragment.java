package com.Liufeng.MyViewPager;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.Liufeng.MyViewPager.adapter.mainChatAdapter;
import com.Liufeng.MyViewPager.model.MChatFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/23.
 */

public class MainChatFragment extends Fragment {
    private ListView listView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_chat, container, false);
        initListView(rootView);
        return rootView;
    }

    private void initListView(View view) {
        listView = (ListView) view.findViewById(R.id.one_listView);
        listView.setAdapter(new mainChatAdapter(getData(),getActivity()));
    }

    private List<MChatFragment> getData() {
        List<MChatFragment> chatFragmentList = new ArrayList<>();
        for (int i = 0; i < 51; i++) {
            chatFragmentList.add(new MChatFragment("","昵称" + i,"18:00","我就是我,就是我"));
        }
        return chatFragmentList;
    }
}
