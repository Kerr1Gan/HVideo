package com.ethan.and.fragments;

import com.common.componentes.fragment.LazyInitFragment;

public class VideoListFragment extends LazyInitFragment {

    public static VideoListFragment newInstance() {
        return new VideoListFragment();
    }

    @Override
    public void onUserVisibleHintChanged(boolean isVisibleToUser) {
        super.onUserVisibleHintChanged(isVisibleToUser);
    }
}
