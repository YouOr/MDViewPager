package com.Liufeng.MyViewPager.util;

import android.text.TextUtils;
import android.util.Log;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
 * Created by Administrator on 2017/5/25.
 */
public class pinyinUtil {
    /**
     * 汉字String 转拼音
     *
     * @param chinese
     * @return
     */
    public static String getPinYin(String chinese) {
        String pinYinStr = "";
        if (TextUtils.isEmpty(chinese)) {
            return pinYinStr;
        }
        //开始转换
        HanyuPinyinOutputFormat pinyinOutputFormat = new HanyuPinyinOutputFormat();
        //设置pinyin格式不带音标
        pinyinOutputFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        //设置pinyin大小写
        pinyinOutputFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        //设置piny V or U
        pinyinOutputFormat.setVCharType(HanyuPinyinVCharType.WITH_V);
        Log.i("pinyinUtil",chinese);
        char[] tCharArray = chinese.trim().toCharArray();  //把汉字转换为char数组
        String reg = "[\\u4e00-\\u9fa5]";   //汉字的ascii范围
        for (char tChar : tCharArray) {
            String strChar = Character.toString(tChar);
            if (strChar.matches(reg)) { //汉字
                try {
                    String[] pinYinStringArray = PinyinHelper.toHanyuPinyinStringArray(tChar, pinyinOutputFormat);
                    pinYinStr += pinYinStringArray[0];
                } catch (BadHanyuPinyinOutputFormatCombination badHanyuPinyinOutputFormatCombination) {
                    badHanyuPinyinOutputFormatCombination.printStackTrace();
                }
            } else //不是汉字,不转换
            {
                pinYinStr += strChar;
            }
        }
        return pinYinStr;
    }
}
