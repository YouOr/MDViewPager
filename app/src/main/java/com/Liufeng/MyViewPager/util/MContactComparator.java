package com.Liufeng.MyViewPager.util;

import com.Liufeng.MyViewPager.model.Mcontact;

import java.util.Comparator;

/**
 * 通讯录实体对象比较器
 * Created by Administrator on 2017/5/25.
 */
public class MContactComparator implements Comparator<Mcontact> {
    /**
     * 定义比较规则：
     * 1.Mcontact headerletter属性比较，a<b<c<d...(Ascii) a=A
     * 2."#" 最大
     *
     * @param o1
     * @param o2
     * @return o1>o2 正; o1<o2 负；o1==o2 0;
     */
    @Override
    public int compare(Mcontact o1, Mcontact o2) {
        String o1HeaderLetter = o1.getHeaderletter().toLowerCase();
        String o2HeaderLetter = o2.getHeaderletter().toLowerCase();
        if ("#".equals(o1HeaderLetter)) {
            return 1;
        }
        if ("#".equals(o2HeaderLetter)) {
            return -1;
        }
        return o1HeaderLetter.compareTo(o2HeaderLetter);// a b 97-98; b c 98-99; c a 99-97
    }
}
