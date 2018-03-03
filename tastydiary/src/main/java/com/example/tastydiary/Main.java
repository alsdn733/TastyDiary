package com.example.tastydiary;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Main extends AppCompatActivity {

    ListView mMemoListView;
    MemoListAdapter mMemoListAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        mMemoListView = (ListView) findViewById(R.id.memoList);
        mMemoListAdapter = new MemoListAdapter(this);
        mMemoListAdapter.addItem(new MemoItem("굽네치킨", "2012년 4월 8일"));
        mMemoListAdapter.addItem(new MemoItem("BBQ", "2013년 6월 9일"));
        mMemoListAdapter.addItem(new MemoItem("또래오래", "2015년 12월 22일"));
        mMemoListAdapter.addItem(new MemoItem("네네치킨", "2017년 10월 20일"));
        mMemoListAdapter.addItem(new MemoItem("교촌치킨", "2018년 3월 3일"));
        mMemoListView.setAdapter(mMemoListAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}
