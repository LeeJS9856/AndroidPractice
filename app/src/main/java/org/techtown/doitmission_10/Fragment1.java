package org.techtown.doitmission_10;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;

public class Fragment1 extends Fragment {

    ViewPager pager;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_1, container, false);

        pager = (ViewPager) rootView.findViewById(R.id.pager);

        pager.setOffscreenPageLimit(3);

        Adapter adapter = new Adapter(getFragmentManager());

        Fragment1 fragment_1 = new Fragment1();
        adapter.addItem(fragment_1);

        Fragment2 fragment_2 = new Fragment2();
        adapter.addItem(fragment_2);

        Fragment3 fragment_3 = new Fragment3();
        adapter.addItem(fragment_3);

        pager.setAdapter(adapter);


        return rootView;
    }

    class Adapter extends FragmentStatePagerAdapter {
        ArrayList<Fragment> items = new ArrayList<Fragment>();

        public Adapter(FragmentManager fm) {
            super(fm);
        }

        public void addItem(Fragment item) {
            items.add(item);
        }

        public Fragment getItem(int position) {
            return items.get(position);
        }

        public int getCount() {
            return items.size();
        }
    }


}

