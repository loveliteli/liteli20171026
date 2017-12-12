package com.exbawei.liteli.liteli1507a20171026.presenter;

import com.exbawei.liteli.liteli1507a20171026.bean.Bean;
import com.exbawei.liteli.liteli1507a20171026.contract.Contract;
import com.exbawei.liteli.liteli1507a20171026.model.Model;

import java.util.List;

import okhttp3.Request;

/**
 * Created by li te li on 2017/10/26.
 */

public class Presenter implements Contract.IPresenter {
Contract.IView iView;
    Model model;
//构造器
    public Presenter(Contract.IView iView) {
        this.iView = iView;
        model=new Model();
    }
//显示数据
    @Override
    public void showData() {
        model.getData(new Model.ImyData() {
            @Override
            public void listData(List<Bean.DataBean.ComicsBean> list) {
                iView.setData(list);
            }
        });


    }
}
