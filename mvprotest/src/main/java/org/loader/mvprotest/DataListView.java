package org.loader.mvprotest;

import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import org.loader.helper.EventHelper;
import org.loader.view.ViewImpl;

import java.util.ArrayList;

/**
 * Created by qibin on 2015/11/15.
 */
public class DataListView extends ViewImpl {

    private Button mButton1, mButton2;
    private ListView mListView;
    private ArrayAdapter<String> mAdapter;

    @Override
    public void created() {
        mButton1 = findViewById(R.id.newdata);
        mButton2 = findViewById(R.id.adddata);
        mListView = findViewById(R.id.list);
    }

    @Override
    public void bindEvent() {
        EventHelper.click(mPresenter, mButton1, mButton2);
        EventHelper.itemClick(mPresenter, mListView);
    }

    @Override
    public int getLayoutId() {
        return R.layout.list_layout;
    }

    public void setData(ArrayList<String> datas) {
        mAdapter = new ArrayAdapter<String>(mRootView.getContext(),
                android.R.layout.simple_list_item_1, datas);
        mListView.setAdapter(mAdapter);
    }

    public void addData(ArrayList<String> datas) {
        mAdapter.addAll(datas);
    }

    public void toast(int position) {
        Toast.makeText(mRootView.getContext(),
                mAdapter.getItem(position), Toast.LENGTH_SHORT).show();
    }
}
