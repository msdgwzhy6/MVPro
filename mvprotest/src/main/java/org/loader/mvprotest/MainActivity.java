package org.loader.mvprotest;

import android.view.View;
import android.widget.AdapterView;

import org.loader.presenter.ActivityPresenterImpl;

import java.util.ArrayList;

public class MainActivity extends ActivityPresenterImpl<DataListView>
        implements AdapterView.OnItemClickListener, View.OnClickListener {

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        mView.toast(position);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.newdata) newData();
        else getData();
    }

    private void newData() {
        new MainBiz().data(new MainBiz.Callback<ArrayList<String>>() {
            @Override
            public void callback(ArrayList<String> data) {
                mView.setData(data);
            }
        });
    }

    private void getData() {
        new MainBiz().data(new MainBiz.Callback<ArrayList<String>>() {
            @Override
            public void callback(ArrayList<String> data) {
                mView.addData(data);
            }
        });
    }
}


/**
public class MainActivity extends ActivityPresenterImpl<MainView> implements View.OnClickListener {

    @Override
    public void afterInitialize() {
        mView.bindPresenter(MainActivity.this);

        mView.setProgress(50);
        new MainBiz().userInfo(new MainBiz.Callback<String>() {
            @Override
            public void callback(String data) {
                mView.setText(data);
                mView.setTextClickListener(MainActivity.this);
            }
        });
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.tv) {
            mView.showToast(mView.getText());
            mView.setProgress(100);
        }
    }
}
*/
