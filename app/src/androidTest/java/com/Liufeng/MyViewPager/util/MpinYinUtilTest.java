package com.Liufeng.MyViewPager.util;

import android.util.Log;

import junit.framework.TestCase;

/**
 * Created by Administrator on 2017/5/25.
 */
public class MpinYinUtilTest extends TestCase {
    String TAG = "MpinYinUtilTest";

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    public void testGetPinYin() {
        String pinyin1 = pinyinUtil.getPinYin("我是");
        String pinyin2 = pinyinUtil.getPinYin("啊----5");
        String pinyin3 = pinyinUtil.getPinYin("123");
        String pinyin4 = pinyinUtil.getPinYin("&……我是i大家");

        Log.i(TAG, pinyin1);
        Log.i(TAG, pinyin2);
        Log.i(TAG, pinyin3);
        Log.i(TAG, pinyin4);
        Log.i(TAG, pinyin4);
    }
}
