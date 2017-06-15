package com.Liufeng.MyViewPager.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.Liufeng.MyViewPager.R;
import com.Liufeng.MyViewPager.model.MChatFragment;

import java.util.List;

/**
 * Created by Administrator on 2017/5/24.
 */
public class mainChatAdapter extends BaseAdapter {
    private List<MChatFragment> mMChatFragment;
    private LayoutInflater inflater;

    public mainChatAdapter(List<MChatFragment> mMChatFragment, Context mContext) {
        this.mMChatFragment = mMChatFragment;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return mMChatFragment.size();
    }

    @Override
    public Object getItem(int position) {
        return mMChatFragment.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    class ViewHolder {
        ImageView img_name_icon;
        TextView nickName, tv_time, tv_content;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.onefragment_lv_item, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.img_name_icon = (ImageView) convertView.findViewById(R.id.img_name_icon);
            viewHolder.nickName = (TextView) convertView.findViewById(R.id.nickName);
            viewHolder.tv_time = (TextView) convertView.findViewById(R.id.tv_time);
            viewHolder.tv_content = (TextView) convertView.findViewById(R.id.tv_content);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        MChatFragment mChatFragment = (MChatFragment) getItem(position);
        viewHolder.nickName.setText(mChatFragment.getNickName());
        viewHolder.tv_content.setText(mChatFragment.getContext());
        viewHolder.tv_time.setText(mChatFragment.getTimeOut());
        return convertView;
    }
}
