package com.example.tastydiary;


import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.tastydiary.MemoCollection.Memo;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvMemo;
    private MemoAdapter memoAdapter;

    public static final int REQUEST_MAIN = 2501;

    public static String TextMemo;

    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);

        setSupportActionBar(myToolbar);

        rvMemo = findViewById(R.id.rvMemo);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvMemo.setLayoutManager(linearLayoutManager);

        memoAdapter = new MemoAdapter();
        rvMemo.setAdapter(memoAdapter);


        fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MemoUtils.class);
                startActivityForResult(intent,REQUEST_MAIN);

            }
        });




    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode != RESULT_OK) {
            return;
        }

        int newIndex = MemoCollection.newMemo();

        memoAdapter.notifyItemInserted(newIndex);
        TextMemo = data.getStringExtra("result");




//        if (requestCode != REQUEST_MAIN) {
//            return;
//        }
//
//        if (resultCode != RESULT_OK) {
//            Toast.makeText(getBaseContext(), "저장을 실패하였습니다.", Toast.LENGTH_SHORT).show();
//        } else {
//
//        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.action_settings:
                Toast.makeText(this, "action_settings", Toast.LENGTH_LONG).show();
                return true;
            case R.id.action_favorite:
                Toast.makeText(this, "action_favorite", Toast.LENGTH_LONG).show();
                return true;
            default:
                Toast.makeText(this, "default", Toast.LENGTH_LONG).show();
                return super.onOptionsItemSelected(item);
        }
    }

    class MemoAdapter  extends RecyclerView.Adapter<MemoViewHolder>{

        @NonNull
        @Override
        public MemoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View listItem = LayoutInflater
                    .from(parent.getContext())
                    .inflate(R.layout.viewholder_memo, parent, false);

            return new MemoViewHolder(listItem);
        }

        @Override
        public void onBindViewHolder(@NonNull MemoViewHolder holder, int position) {

            Memo memo = MemoCollection.getMemo(position);
            memo.memo = TextMemo;
            holder.tvMemo.setText(memo.memo != null ? memo.memo : "메모 없음");
        }

        @Override
        public int getItemCount() {
            return MemoCollection.getSize();
        }
    }


    class MemoViewHolder extends  RecyclerView.ViewHolder{
        private TextView tvMemo;

        MemoViewHolder(View itemView){
            super(itemView);

            tvMemo = itemView.findViewById(R.id.tvMemo);



        }
    }

}

