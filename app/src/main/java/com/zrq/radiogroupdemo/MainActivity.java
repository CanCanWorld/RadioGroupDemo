package com.zrq.radiogroupdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;

import java.util.ArrayList;
import java.util.List;

@SuppressLint("UseSwitchCompatOrMaterialCode")
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private Context context;
    private RadioGroup mRadioGroup;
    private ViewPager2 viewPager2;
    private List<MyFragment> fragments;
    private FragmentPagerAdapter adapter;
    private Switch mSwitchCode;
    private Switch mSwitchCard;
    private Switch mSwitchFace;
    private RadioButton mRbCode;
    private RadioButton mRbCard;
    private RadioButton mRbFace;
    private MyFragment codeFragment;
    private MyFragment cardFragment;
    private MyFragment blankFragment;
    private MyFragment faceFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity_main);
        initView();
        initData();
        initEvent();
    }

    private void initView() {
        mRadioGroup = findViewById(R.id.radio_group);
        viewPager2 = findViewById(R.id.view_pager);
        mSwitchCode = findViewById(R.id.switch_code);
        mSwitchCard = findViewById(R.id.switch_card);
        mSwitchFace = findViewById(R.id.switch_face);
        mRbCode = new RadioButton(context);
        mRbCard = new RadioButton(context);
        mRbFace = new RadioButton(context);
        mRbCode.setId(R.id.rb_code);
        mRbCard.setId(R.id.rb_card);
        mRbFace.setId(R.id.rb_face);
    }

    private void initData() {
        initFragment();
        adapter = new FragmentPagerAdapter(this, context, fragments);
        viewPager2.setAdapter(adapter);
        mSwitchCode.setChecked(true);
        mSwitchCard.setChecked(true);
        mSwitchFace.setChecked(true);
        initRadioGroup();
    }

    private void initFragment() {
        fragments = new ArrayList<>();
        codeFragment = MyFragment.newInstance(new Info("支付宝/微信扫码", "请扫码", R.drawable.code));
        cardFragment = MyFragment.newInstance(new Info("XXX读卡器", "请放卡", R.drawable.card));
        faceFragment = MyFragment.newInstance(new Info("支付宝刷脸", "切换刷脸付", R.drawable.face));
        blankFragment = MyFragment.newInstance(new Info("", "", 0));
        fragments.add(0, codeFragment);
        fragments.add(1, cardFragment);
        fragments.add(2, faceFragment);
        fragments.add(3, blankFragment);
    }

    private void initRadioGroup() {
        mRbCode.setButtonDrawable(R.drawable.selector_code);
        mRbCard.setButtonDrawable(R.drawable.selector_card);
        mRbFace.setButtonDrawable(R.drawable.selector_face);
        mRadioGroup.addView(mRbCode, 0);
        mRadioGroup.addView(mRbCard, 1);
        mRadioGroup.addView(mRbFace, 2);
        mRadioGroup.getChildAt(0).performClick();
    }

    @SuppressLint({"NonConstantResourceId", "NotifyDataSetChanged"})
    private void initEvent() {
        mSwitchCode.setOnCheckedChangeListener((CompoundButton buttonView, boolean isChecked) -> {
            if (isChecked) {
                mRadioGroup.addView(mRbCode);
                mRbCode.setChecked(true);
            } else {
                mRadioGroup.removeView(mRbCode);
                if (mRbCode.isChecked())
                    viewPager2.setCurrentItem(3);
            }
        });
        mSwitchCard.setOnCheckedChangeListener((CompoundButton buttonView, boolean isChecked) -> {
            if (isChecked) {
                mRadioGroup.addView(mRbCard);
                mRbCard.setChecked(true);
            } else {
                mRadioGroup.removeView(mRbCard);
                if (mRbCard.isChecked())
                    viewPager2.setCurrentItem(3);
            }
        });
        mSwitchFace.setOnCheckedChangeListener((CompoundButton buttonView, boolean isChecked) -> {
            if (isChecked) {
                mRadioGroup.addView(mRbFace);
                mRbFace.setChecked(true);
            } else {
                mRadioGroup.removeView(mRbFace);
                if (mRbFace.isChecked())
                    viewPager2.setCurrentItem(3);
            }
        });
        mRbCode.setOnClickListener(v -> {
            viewPager2.setCurrentItem(0);
        });
        mRbCard.setOnClickListener(v -> {
            viewPager2.setCurrentItem(1);
        });
        mRbFace.setOnClickListener(v -> {
            viewPager2.setCurrentItem(2);
        });
        mRadioGroup.setOnCheckedChangeListener((RadioGroup group, int checkedId) -> {
            switch (checkedId) {
                case R.id.rb_code:
                    viewPager2.setCurrentItem(0);
                    break;
                case R.id.rb_card:
                    viewPager2.setCurrentItem(1);
                    break;
                case R.id.rb_face:
                    viewPager2.setCurrentItem(2);
                    break;
            }
        });
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch (position) {
                    case 0:
                        mRbCode.setChecked(true);
                        break;
                    case 1:
                        mRbCard.setChecked(true);
                        break;
                    case 2:
                        mRbFace.setChecked(true);
                        break;
                }
            }
        });
    }
}