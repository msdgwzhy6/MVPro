package org.loader.mvprotest2;

import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import org.loader.helper.EventHelper;
import org.loader.view.ViewImpl;

import java.util.ArrayList;

/**
 * Created by qibin on 2015/11/16.
 */
public class MainFragmentView extends ViewImpl {

    private Button mBtn1, mBtn2;
    private ListView mListView;
    private ArrayAdapter<String> mAdapter;

    @Override
    public void created() {
        mBtn1 = findViewById(R.id.adddata);
        mBtn2 = findViewById(R.id.newdata);
        mListView = findViewById(R.id.list);
    }

    @Override
    public void bindEvent() {
        EventHelper.click(mPresenter, mBtn1, mBtn2);
        EventHelper.itemClick(mPresenter, mListView);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment;
    }

    public void newData(ArrayList<String> data) {
        mAdapter = new ArrayAdapter<String>(mRootView.getContext(),
                android.R.layout.simple_list_item_1, data);
        mListView.setAdapter(mAdapter);
    }

    public void addData(ArrayList<String> data) {
        mAdapter.addAll(data);
    }

    public void toast(String str) {
        Toast.makeText(mRootView.getContext(), str, Toast.LENGTH_SHORT).show();
    }
}
