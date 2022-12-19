package views.memo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.wonderland.R;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import views.memo.db.MemoOperator;

public class MemoActivity extends AppCompatActivity {

    private Button mBtnAddMemo;
    private ListView mLvMemos;
    private TextView mTvToday;
    final MemoOperator memoOperator = new MemoOperator(MemoActivity.this);
    private ArrayList<HashMap<String, String>> memoList;
    private String time;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo);
        assignViews();
        initData();
        initViews();
        setListeners();
    }

    private void assignViews() {
        mBtnAddMemo = findViewById(R.id.btn_add_memo);
        mLvMemos = findViewById(R.id.lv_memos);
        mTvToday = findViewById(R.id.tv_today);
        adapter = new MyAdapter(MemoActivity.this);
    }

    private void initViews() {
        mTvToday.setText(time);
        adapter.setList(this.memoList);
        mLvMemos.setAdapter(adapter);
    }

    private void initData() {
        Date date = new Date();
        time = date.toLocaleString().split(" ")[0];
        this.memoList = memoOperator.getMemoList();
    }

    private void setListeners() {
        mBtnAddMemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MemoActivity.this,AddMemoActivity.class);
                startActivity(intent);
            }
        });
    }
}