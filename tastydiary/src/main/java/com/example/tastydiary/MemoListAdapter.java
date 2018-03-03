package com.example.tastydiary;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public class MemoListAdapter extends BaseAdapter {

    ArrayList<MemoItem> items = new ArrayList<MemoItem>();

    private Context mContext;

    public MemoListAdapter(Context context) {
        mContext = context;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    public void addItem(MemoItem item){
        items.add(item);
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MemoItemView view = new MemoItemView(mContext);
        MemoItem item = items.get(position);
        view.setSub(item.getSubject());
        view.setDate(item.getDate());
        return view;
    }
}
