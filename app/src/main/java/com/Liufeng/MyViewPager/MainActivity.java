package com.Liufeng.MyViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private ViewPager viewPager;
    private List<Fragment> fragmentList;
    private ImageView icon_chat, icon_contacts, icon_find, icon_set;
    private TextView tv_chat, tv_contacts, tv_find, tv_set;
    private LinearLayout layout_chat, layout_contacts, layout_find, layout_set;
    private TextView[] tv_title;
    private ImageView[] img_icon;
    private LinearLayout[] layouts;
    private DrawerLayout drawer_layout;
    private NavigationView navigationView;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initToolbar();
        initTabButton();
        initViewPager();
        initNaView();
    }

    private void initNaView() {
        drawer_layout= (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView= (NavigationView) findViewById(R.id.nav_View);
        navigationView.setCheckedItem(R.id.nav_call);
        fab= (FloatingActionButton) findViewById(R.id.btn_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, FruitActivity.class);
                startActivity(intent);
//                Toast.makeText(MainActivity.this,"点击了悬浮按钮",Toast.LENGTH_SHORT).show();
            }
        });
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                drawer_layout.closeDrawers();
                return true;
            }
        });
    }

    private void initTabButton() {
        icon_chat = (ImageView) findViewById(R.id.img_chat);
        icon_contacts = (ImageView) findViewById(R.id.img_contacts);
        icon_find = (ImageView) findViewById(R.id.img_find);
        icon_set = (ImageView) findViewById(R.id.img_set);
        img_icon = new ImageView[]{icon_chat, icon_contacts, icon_find, icon_set};

        tv_chat = (TextView) findViewById(R.id.tv_chat);
        tv_contacts = (TextView) findViewById(R.id.tv_contacts);
        tv_find = (TextView) findViewById(R.id.tv_find);
        tv_set = (TextView) findViewById(R.id.tv_set);
        tv_title = new TextView[]{tv_chat, tv_contacts, tv_find, tv_set};

        layout_chat = (LinearLayout) findViewById(R.id.layout_chat);
        layout_contacts = (LinearLayout) findViewById(R.id.layout_contacts);
        layout_find = (LinearLayout) findViewById(R.id.layout_find);
        layout_set = (LinearLayout) findViewById(R.id.layout_set);
        layouts = new LinearLayout[]{layout_chat, layout_contacts, layout_find, layout_set};

//        icon_chat.setImageDrawable(getResources().getDrawable(R.drawable.one_2));
//        tv_chat.setTextColor(getResources().getColor(R.color.main_tab_button_textColor_Selected));

        setSelectTabButton(0);
        switchPageWhenTabClick();
    }

    /**
     * 实现了点击TabButton切换页面和样式
     */
    private void switchPageWhenTabClick() {
        View.OnClickListener onTabButtonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.layout_chat:
                        switchPage(0);
                        break;
                    case R.id.layout_contacts:
                        switchPage(1);
                        break;
                    case R.id.layout_find:
                        switchPage(2);
                        break;
                    case R.id.layout_set:
                        switchPage(3);
                        break;
                }
            }
        };
        for (LinearLayout layout : layouts) {
            layout.setOnClickListener(onTabButtonClickListener);
        }
    }

    private void switchPage(int item) {
        viewPager.setCurrentItem(item);
        setSelectTabButton(item);
    }

    private void initViewPager() {
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        fragmentList = new ArrayList<>();
        fragmentList.add(new MainChatFragment());
        fragmentList.add(new MainContactFragment());
        fragmentList.add(new MainFindFragment());
        fragmentList.add(new MainSetFragment());
        FragmentPagerAdapter fragmentPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public int getCount() {
                return fragmentList.size();
            }

            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }
        };
        viewPager.setAdapter(fragmentPagerAdapter);
        setSelectedTabButtonLookChange();
    }

    private void setSelectedTabButtonLookChange() {
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            //页面切换的回调
            @Override
            public void onPageSelected(int position) {
//                switch (position) {
//                    case 0:
//                        icon_chat.setImageDrawable(getResources().getDrawable(R.drawable.one_2));
//                        tv_chat.setTextColor(getResources().getColor(R.color.main_tab_button_textColor_Selected));
//                        break;
//                    case 1:
//                        icon_contacts.setImageDrawable(getResources().getDrawable(R.drawable.two_2));
//                        tv_contacts.setTextColor(getResources().getColor(R.color.main_tab_button_textColor_Selected));
//                        break;
//                    case 2:
//                        icon_find.setImageDrawable(getResources().getDrawable(R.drawable.three_2));
//                        tv_find.setTextColor(getResources().getColor(R.color.main_tab_button_textColor_Selected));
//                        break;
//                    case 3:
//                        icon_set.setImageDrawable(getResources().getDrawable(R.drawable.four_2));
//                        tv_set.setTextColor(getResources().getColor(R.color.main_tab_button_textColor_Selected));
//                        break;
//                }
                setSelectTabButton(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void resetTabButton() {
//        icon_chat.setImageDrawable(getResources().getDrawable(R.drawable.one_1));
//        icon_contacts.setImageDrawable(getResources().getDrawable(R.drawable.two_1));
//        icon_find.setImageDrawable(getResources().getDrawable(R.drawable.three_1));
//        icon_set.setImageDrawable(getResources().getDrawable(R.drawable.four_1));

//        for (ImageView img : img_icon) {
//            img.setSelected(false);
//        }
//        for (TextView tv : tv_title) {
//            tv.setSelected(false);
//        }
        for (LinearLayout layout : layouts) {
            layout.setSelected(false);
        }

//        for (TextView tv : tv_title) {
//            tv.setTextColor(getResources().getColor(R.color.main_tab_button_textColor_Default));
//        }
    }

    private void setSelectTabButton(int index) {
        resetTabButton();//所有TabButton恢复默认样式
//        img_icon[index].setSelected(true);
//        tv_title[index].setSelected(true);
        layouts[index].setSelected(true);
    }

    private void initToolbar() {
        toolbar = (Toolbar) this.findViewById(R.id.toolBar);
        //      将toolbar设置为兼容的actionBar
        toolbar.setTitle("My项目");
        setSupportActionBar(toolbar);

       ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.people);
        }

    }

    //加载菜单
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_search:
                Toast.makeText(this,"点击了搜索",Toast.LENGTH_SHORT).show();
                break;
            case android.R.id.home:
                drawer_layout.openDrawer(GravityCompat.START);
                break;
            case R.id.action_newChat:
                Toast.makeText(this,"点击了群聊",Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    //        重写实现overFlow 菜单项icon的显示
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        if (menu != null) {
            if (menu.getClass() == MenuBuilder.class) {
                try {
                    Method m = menu.getClass().getDeclaredMethod("setOptionalIconsVisible", Boolean.TYPE);
                    m.setAccessible(true);
                    m.invoke(menu, true);
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return super.onPrepareOptionsMenu(menu);
    }
}
