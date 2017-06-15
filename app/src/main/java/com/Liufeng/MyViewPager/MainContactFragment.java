package com.Liufeng.MyViewPager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.Liufeng.MyViewPager.adapter.ContatsAdapter;
import com.Liufeng.MyViewPager.model.Mcontact;
import com.Liufeng.MyViewPager.util.pinyinUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/23.
 */

public class MainContactFragment extends Fragment {
    private List<Mcontact> contacts;
    private ListView listView;
//    private String [] A_Z=getResources().getStringArray(R.array.SortABCF);

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_contact, container, false);
        initListView(rootView);
        return rootView;
    }

    private void initListView(View view) {
        listView = (ListView) view.findViewById(R.id.lv_contacts);
        getContactsListDatas();
        listView.setAdapter(new ContatsAdapter(contacts, getActivity()));
    }

    /**
     * 从xml文件的array数组里获取数据
     */
    private void getContactsListDatas() {
        contacts = new ArrayList<>();
        String[] nickNameArray = getResources().getStringArray(R.array.array_contactNickName);
        for (String nickName : nickNameArray) {
            Mcontact mContact = new Mcontact();
            mContact.setNickName(nickName);
            //排除 拼音字符串 首字符 不是字母的情况  "#" , or 小写字母
            String pinyin = pinyinUtil.getPinYin(nickName);
            if (TextUtils.isEmpty(pinyin)) {
                mContact.setHeaderletter("#");
            } else if (Character.toString(pinyin.charAt(0)).matches("[a-zA-Z]]")) {
                //设置为小写字母
                mContact.setHeaderletter(Character.toString(pinyin.charAt(0)).toLowerCase());
            } else {
                mContact.setHeaderletter("#");
            }
            contacts.add(mContact);
        }

    }
}
