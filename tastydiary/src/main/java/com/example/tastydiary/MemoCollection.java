package com.example.tastydiary;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MemoCollection {
    private static List<Memo> MemoList = new ArrayList<>();

    public static int newMemo(){
        Memo memo = new Memo();
        MemoList.add(memo);

        return MemoList.size();
    }

    public static Memo getMemo(int index) {
        return MemoList.get(index);
    }

    public static int getSize() {return MemoList.size();}

    static class Memo {
        private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.ENGLISH);

        long date;

        String memo;

        Memo(){
            date = System.currentTimeMillis();

        }

        public void setMemo(String _memo) {
            memo = _memo;
        }
    }
}
