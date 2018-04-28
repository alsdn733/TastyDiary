package com.example.tastydiary;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import static com.example.tastydiary.MemoCollection.Memo;

public class MemoUtils extends AppCompatActivity {


    private static EditText etText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.memo_write);

        etText = (EditText) findViewById(R.id.etText);

    }

    public void MemoSave(View view) {

        Intent resultIntent = new Intent();
        resultIntent.putExtra("result", etText.getText().toString());
        setResult(RESULT_OK, resultIntent);

        finish();
    }

}
