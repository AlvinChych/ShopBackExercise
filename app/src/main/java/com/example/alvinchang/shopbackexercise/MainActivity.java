package com.example.alvinchang.shopbackexercise;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.example.alvinchang.shopbackexercise.ui.view.UsersFragment;

public class MainActivity extends AppCompatActivity {

    private Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPresenter = new Presenter();
        if (savedInstanceState == null) {
            displayUserFragment();
        }
    }

    private void setFragment(Fragment fragment, String fragmentName) {
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.container, fragment, fragmentName)
                .commit();
    }

    private void displayUserFragment() {
        setTitle("GitHub Users");
        setFragment(UsersFragment.newInstance(), UsersFragment.class.getSimpleName());
    }

    public Presenter getPresenter() {
        return mPresenter;
    }
}
