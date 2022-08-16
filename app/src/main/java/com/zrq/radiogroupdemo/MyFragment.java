package com.zrq.radiogroupdemo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MyFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MyFragment extends Fragment {

    private TextView mTvTitle;
    private TextView mTvDetail;
    private ImageView mIvImg;
    private final Info info;

    public MyFragment(Info info) {
        // Required empty public constructor
        this.info = info;
    }

    public static MyFragment newInstance(Info info) {
        return new MyFragment(info);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my, container, false);
        initView(view);
        initData();
        return view;
    }

    private void initView(View view) {
        mTvTitle = view.findViewById(R.id.tv_title);
        mTvDetail = view.findViewById(R.id.tv_detail);
        mIvImg = view.findViewById(R.id.iv_img);
    }

    private void initData() {
        mTvTitle.setText(info.getTitle());
        mTvDetail.setText(info.getDetail());
        if (info.getImg() != 0) {
            mIvImg.setImageResource(info.getImg());
        }
    }
}