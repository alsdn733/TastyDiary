package com.example.tastydiary;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MemoItemView extends LinearLayout {

    TextView tvSub;
    TextView tvDate;


    public MemoItemView(Context context) {
        super(context);
        init(context);
    }

    public MemoItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.memo_listitem, this, true);

        tvSub = (TextView) findViewById(R.id.tvSub);
        tvDate = (TextView) findViewById(R.id.tvDate);


    }

    public void setSub(String sub ) {
        tvSub.setText(sub);
    }

    public void setDate(String date ) {
        tvDate.setText(date);
    }

}
