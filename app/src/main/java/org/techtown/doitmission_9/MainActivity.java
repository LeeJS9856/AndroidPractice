package org.techtown.doitmission_9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    cusInfoFragment CusInfoFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CusInfoFragment = new cusInfoFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.container, CusInfoFragment).commit();
    }
}