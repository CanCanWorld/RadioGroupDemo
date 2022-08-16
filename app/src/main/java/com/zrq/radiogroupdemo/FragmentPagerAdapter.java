package com.zrq.radiogroupdemo;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;
import java.util.List;

public class FragmentPagerAdapter extends FragmentStateAdapter {

    private Context context;
    private List<MyFragment> fragments = new ArrayList<>();

    public FragmentPagerAdapter(@NonNull FragmentActivity fragmentActivity, Context context, List<MyFragment> fragments) {
        super(fragmentActivity);
        this.context = context;
        this.fragments.clear();
        this.fragments.addAll(fragments);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragments.get(position);
    }

    @Override
    public int getItemCount() {
        return fragments.size();
    }

}
