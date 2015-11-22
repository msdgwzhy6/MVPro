package org.loader.mvprotest2;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;

import org.loader.presenter.FragmentActivityPresenterImpl;

public class MainActivity extends FragmentActivityPresenterImpl<MainView> {

    @Override
    public void created(Bundle savedInstance) {
        FragmentManager fm = getSupportFragmentManager();
        if(savedInstance == null) {
            mView.showFragment(fm);
        }else {
            mView.restoreFragment(fm);
        }
    }
}
