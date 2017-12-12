package com.exbawei.liteli.liteli1507a20171026.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.exbawei.liteli.liteli1507a20171026.R;
import com.exbawei.liteli.liteli1507a20171026.SecondActivity;
import com.exbawei.liteli.liteli1507a20171026.adapter.Myadapter;
import com.exbawei.liteli.liteli1507a20171026.bean.Bean;
import com.exbawei.liteli.liteli1507a20171026.contract.Contract;
import com.exbawei.liteli.liteli1507a20171026.onclitener.OnClickRecyclerListner;
import com.exbawei.liteli.liteli1507a20171026.presenter.Presenter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements Contract.IView{
Presenter presenter = new Presenter(this);
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //控件
        rv = (RecyclerView) findViewById(R.id.rv);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(layoutManager);
      presenter.showData();

    }

    @Override
    public void setData(List<Bean.DataBean.ComicsBean> list) {

        Myadapter adapter = new Myadapter(list,MainActivity.this);
        //点击事件
        adapter.setLister(new OnClickRecyclerListner() {
            @Override
            public void onItemClick(View view, int position) {
                //跳转
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        });
        rv.setAdapter(adapter);
    }

}
