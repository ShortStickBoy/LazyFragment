package com.sunzn.fragment.subs;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sunzn.fragment.R;
import com.sunzn.fragment.base.BaseFragment;

public class ImageFragment extends BaseFragment {

    private boolean isLoadSuccess = false;

    public static ImageFragment newInstance() {
        return new ImageFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_image, container, false);
    }

    @Override
    public void init() {
        Log.e(TAG, "ImageFragment.onViewCreated() 初始化完毕");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getUserVisibleHint() && !isLoadSuccess) {
            Log.e(TAG, "ImageFragment.onActivityCreated() 加载数据");
            loadData();
        }
    }

    @Override
    public void onUserVisibleHints() {
        if (isInitComplete() && !isLoadSuccess) {
            Log.e(TAG, "ImageFragment.onUserVisibleHint() 加载数据");
            loadData();
        }
    }

    private void loadData() {
        isLoadSuccess = true;
    }

}
