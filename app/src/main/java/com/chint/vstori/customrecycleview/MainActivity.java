package com.chint.vstori.customrecycleview;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.chint.vstori.loadadapter.LoadMoreScrollListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements MainAdapter.LoadMoreListener{


    List<PersonBean> list = new ArrayList<>();
    RecyclerView recyclerView;

    MainAdapter adapter;
    SwipeRefreshLayout layout;

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){

                case 1:
                    adapter.setErrorStatus();
                    break;
                case 2:
                    adapter.setLastedStatus();
                    break;
                case 3:
                    List<PersonBean> list = new ArrayList<>();
                    for (int i = 0; i < 10; i++) {
                        list.add(new PersonBean("青蛙要fly"+i,"稳"+i));
                    }
                    adapter.addList(list);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycle_view);

        for (int i = 0; i < 10; i++) {
            list.add(new PersonBean("青蛙要fly"+i,"稳"+i));
        }

        adapter = new MainAdapter(this,list,this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setOnScrollListener(new LoadMoreScrollListener(recyclerView));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void loadMoreData() {
        if(adapter.isLoading()){
            return;
        }
        adapter.setLoading(true);
        Random random = new Random();
        int randomInt = random.nextInt(3)+1;
        Log.v("dyp","random:"+randomInt);
        if(randomInt == 1){
            handler.sendEmptyMessageDelayed(1,3000);
        }else if(randomInt == 2){
            handler.sendEmptyMessageDelayed(2,3000);
        }else{
            handler.sendEmptyMessageDelayed(3,3000);
        }



    }
}