package org.techtown.doitmission_10.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

import org.techtown.doitmission_10.Fragment1;
import org.techtown.doitmission_10.Fragment2;
import org.techtown.doitmission_10.Fragment3;
import org.techtown.doitmission_10.R;
import org.techtown.doitmission_10.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    Fragment1 fragment1;
    Fragment2 fragment2;
    Fragment3 fragment3;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home,container,false);

        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();

        getFragmentManager().beginTransaction().replace(R.id.container, fragment1).commit();

        BottomNavigationView bottomNavigationView = (BottomNavigationView)rootView.findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    public boolean onNavigationItemSelected(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.tab1:
                                getFragmentManager().beginTransaction().replace(R.id.container, fragment1).commit();
                                return true;

                            case R.id.tab2:
                                getFragmentManager().beginTransaction().replace(R.id.container, fragment2).commit();
                                return true;

                            case R.id.tab3:
                                getFragmentManager().beginTransaction().replace(R.id.container, fragment3).commit();
                                return true;
                        }

                        return false;
                    }
                }
        );


        return rootView;


    }



}