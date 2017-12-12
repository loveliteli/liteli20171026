package com.exbawei.liteli.liteli1507a20171026.contract;

import com.exbawei.liteli.liteli1507a20171026.bean.Bean;
import com.exbawei.liteli.liteli1507a20171026.model.Model;

import java.util.List;

/**
 * Created by li te li on 2017/10/26.
 */

public class Contract {
    //得到数据
    public  interface IModel{
  List<Bean.DataBean.ComicsBean> getData(Model.ImyData data);
    }
    //获取
    public  interface IView{
   void  setData(List<Bean.DataBean.ComicsBean> list);
    }
    //显示
    public  interface IPresenter{
     void showData();
    }
}
