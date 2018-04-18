package com.sunzn.fragment.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

public abstract class BaseFragment extends Fragment {

    public static final String TAG = "LAZY";

    public abstract void init();

    private boolean isInitComplete = false;

    public boolean isInitComplete() {
        return isInitComplete;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
        isInitComplete = true;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        if (isVisibleToUser) onUserVisibleHints();
        super.setUserVisibleHint(isVisibleToUser);
    }

    public void onUserVisibleHints() {
        // TODO
    }

}
