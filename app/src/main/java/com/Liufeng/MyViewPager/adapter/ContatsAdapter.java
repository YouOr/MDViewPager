package com.Liufeng.MyViewPager.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.Liufeng.MyViewPager.R;
import com.Liufeng.MyViewPager.model.Mcontact;

import java.util.List;

/**
 * Created by Administrator on 2017/5/25.
 */
public class ContatsAdapter extends BaseAdapter {
    private List<Mcontact> contacts;
    private LayoutInflater inflater;

    public ContatsAdapter() {
    }

    public ContatsAdapter(List<Mcontact> contacts, Context mContext) {
        this.contacts = contacts;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return contacts.size();
    }

    @Override
    public Object getItem(int position) {
        return contacts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.twofragment_lv_item, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.img_avaTor = (ImageView) convertView.findViewById(R.id.img_avaTor);
            viewHolder.tv_contactSelection = (TextView) convertView.findViewById(R.id.tv_contactSelection);
            viewHolder.tv_nickName = (TextView) convertView.findViewById(R.id.tv_nickName);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Mcontact mContants = (Mcontact) getItem(position);
        viewHolder.tv_contactSelection.setText(mContants.getHeaderletter());
        viewHolder.tv_nickName.setText(mContants.getNickName());
        return convertView;
    }

    class ViewHolder {
        ImageView img_avaTor;
        TextView tv_contactSelection, tv_nickName;
    }
}
