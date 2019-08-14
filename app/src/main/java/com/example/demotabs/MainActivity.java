package com.example.demotabs;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
public class MainActivity extends AppCompatActivity {
        private ViewPager viewPager;
        private TabLayout mTabLayout;
        Button addbtn;
        Button remove ;
        static int n=2;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);
                initViews();
        }
        private void initViews(){

                viewPager = findViewById(R.id.viewpager);
                addbtn=findViewById(R.id.add_button);
                mTabLayout =  findViewById(R.id.tabs);
                remove=findViewById(R.id.remove_button);
                viewPager.setOffscreenPageLimit(5);
                viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
                mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                        @Override
                        public void onTabSelected(TabLayout.Tab tab) {
                                viewPager.setCurrentItem(tab.getPosition());
                        }

                        @Override
                        public void onTabUnselected(TabLayout.Tab tab) {

                        }

                        @Override
                        public void onTabReselected(TabLayout.Tab tab) {

                        }
                });


                setDefaulttab();


                addbtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                //event

                                setDynamicFragmentToTabLayout();

                        }
                });

                remove.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                //event

                                removeDynamicFragmentToTabLayout();
                                n++;
                        }
                });

        }

        private void setDefaulttab() {
                for (int i = 0; i <=1; i++) {

                        mTabLayout.addTab(mTabLayout.newTab().setText("Category: " + i));
                }
                DynamicFragmentAdapter mDynamicFragmentAdapter = new DynamicFragmentAdapter(getSupportFragmentManager(), mTabLayout.getTabCount());
                viewPager.setAdapter(mDynamicFragmentAdapter);
                viewPager.setCurrentItem(0);
        }

        private void setDynamicFragmentToTabLayout() {
                int count = mTabLayout.getTabCount();
                for (int i = count; i <= count; i++) {

                        mTabLayout.addTab(mTabLayout.newTab().setText("Category: " + i));
                }
                DynamicFragmentAdapter mDynamicFragmentAdapter = new DynamicFragmentAdapter(getSupportFragmentManager(), mTabLayout.getTabCount());
                viewPager.setAdapter(mDynamicFragmentAdapter);
                viewPager.setCurrentItem(0);

        }

        private void removeDynamicFragmentToTabLayout() {
                TabLayout tabLayout = findViewById(R.id.tabs);
                int totalTabs = tabLayout.getTabCount();
                        mTabLayout.removeTabAt(totalTabs-1); }
}
