package org.loader.mvprotest2;

import android.view.View;
import android.widget.AdapterView;

import org.loader.presenter.FragmentPresenterImpl;

import java.util.ArrayList;

/**
 * Created by qibin on 2015/11/16.
 */
public class MyFragment extends FragmentPresenterImpl<MainFragmentView>
    implements View.OnClickListener, AdapterView.OnItemClickListener{

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.newdata) newData();
        else addData();
    }

    private void newData() {
        new MainBiz().info(new MainBiz.Callback<ArrayList<String>>() {
            @Override
            public void callback(ArrayList<String> data) {
                if(data == null || data.isEmpty()) {
                    mView.toast("没有数据");
                    return;
                }

                mView.newData(data);
            }
        });
    }

    private void addData() {
        new MainBiz().info(new MainBiz.Callback<ArrayList<String>>() {
            @Override
            public void callback(ArrayList<String> data) {
                if(data == null || data.isEmpty()) {
                    mView.toast("没有数据");
                    return;
                }

                mView.addData(data);
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
