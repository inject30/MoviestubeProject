package com.free.top.tvshows.tube.fragments.watchlist;

import android.os.Bundle;

import com.free.top.tvshows.tube.R;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class WatchlistFragment extends Fragment {

    public WatchlistFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(R.string.watchlist);

        View view = inflater.inflate(R.layout.fragment_viewpager, container, false);

        ViewPager viewPager = view.findViewById(R.id.viewpager);
        viewPager.setAdapter(new TabsPagerAdapter(getChildFragmentManager()));

        TabLayout tabLayout = getActivity().findViewById(R.id.tab_layout);
        tabLayout.setVisibility(View.VISIBLE);
        tabLayout.setupWithViewPager(viewPager);

        return view;
    }

    private class TabsPagerAdapter extends FragmentPagerAdapter {

        private String[] tabs = {
                getString(R.string.movies),
                getString(R.string.tv_shows)
        };

        TabsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return tabs.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabs[position];
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new MoviesWatchlistTab();
                case 1:
                    return new TVShowsWatchlistTab();
                default:
                    return null;
            }
        }
    }
}
