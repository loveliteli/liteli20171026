package com.exbawei.liteli.liteli1507a20171026.model;

        import com.exbawei.liteli.liteli1507a20171026.bean.Bean;
        import com.exbawei.liteli.liteli1507a20171026.contract.Contract;
        import com.exbawei.liteli.liteli1507a20171026.utils.GsonObjectCallback;
        import com.exbawei.liteli.liteli1507a20171026.utils.OkHttp3Utils;

        import java.io.IOException;
        import java.util.ArrayList;
        import java.util.List;

        import okhttp3.Call;


/**
 * Created by li te li on 2017/10/26.
 */

public class Model implements Contract.IModel{
    //接口
    String url="http://api.kkmh.com/v1/daily/comic_lists/0?since=0&gender=0&sa_event=eyJwcm9qZWN0Ijoia3VhaWthbl9hcHAiLCJ0aW1lIjoxNDg3NzQyMjQwNjE1LCJwcm9wZXJ0aWVzIjp7IkhvbWVwYWdlVGFiTmFtZSI6IueDremXqCIsIlZDb21tdW5pdHlUYWJOYW1lIjoi54Ot6ZeoIiwiJG9zX3ZlcnNpb24iOiI0LjQuMiIsIkdlbmRlclR5cGUiOiLlpbPniYgiLCJGcm9tSG9tZXBhZ2VUYWJOYW1lIjoi54Ot6ZeoIiwiJGxpYl92ZXJzaW9uIjoiMS42LjEzIiwiJG5ldHdvcmtfdHlwZSI6IldJRkkiLCIkd2lmaSI6dHJ1ZSwiJG1hbnVmYWN0dXJlciI6ImJpZ25veCIsIkZyb21Ib21lcGFnZVVwZGF0ZURhdGUiOjAsIiRzY3JlZW5faGVpZ2h0IjoxMjgwLCJIb21lcGFnZVVwZGF0ZURhdGUiOjAsIlByb3BlcnR5RXZlbnQiOiJSZWFkSG9tZVBhZ2UiLCJGaW5kVGFiTmFtZSI6IuaOqOiNkCIsImFidGVzdF9ncm91cCI6MTEsIiRzY3JlZW5fd2lkdGgiOjcyMCwiJG9zIjoiQW5kcm9pZCIsIlRyaWdnZXJQYWdlIjoiSG9tZVBhZ2UiLCIkY2FycmllciI6IkNoaW5hIE1vYmlsZSIsIiRtb2RlbCI6IlZQaG9uZSIsIiRhcHBfdmVyc2lvbiI6IjMuNi4yIn0sInR5cGUiOiJ0cmFjayIsImRpc3RpbmN0X2lkIjoiQTo2YWRkYzdhZTQ1MjUwMzY1Iiwib3JpZ2luYWxfaWQiOiJBOjZhZGRjN2FlNDUyNTAzNjUiLCJldmVudCI6IlJlYWRIb21lUGFnZSJ9";
    List<Bean.DataBean.ComicsBean> list = new ArrayList<>();
    @Override
    public List<Bean.DataBean.ComicsBean> getData(final ImyData data) {
        //okhttp
        OkHttp3Utils.doGet(url, new GsonObjectCallback<Bean>() {
            @Override
            public void onUi(Bean bean) {
//               list.addAll(bean.getData().getComics());
                List<Bean.DataBean.ComicsBean> comics = bean.getData().getComics();
                data.listData(comics);

            }

            @Override
            public void onFailed(Call call, IOException e) {

            }
        });
        return list;
    }
    public  interface  ImyData{
        void listData(List<Bean.DataBean.ComicsBean> list);
    }
}
