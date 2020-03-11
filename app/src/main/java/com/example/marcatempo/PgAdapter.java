package com.example.marcatempo;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class PgAdapter extends FragmentPagerAdapter {
    int numTabs;

    public PgAdapter(@NonNull FragmentManager fm, int numTabs) {
        super(fm);
        this.numTabs = numTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new Cronometro();
            case 1:
                return new Temporizador();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numTabs;
    }
}
