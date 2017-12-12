package com.exbawei.liteli.liteli1507a20171026.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.exbawei.liteli.liteli1507a20171026.R;
import com.exbawei.liteli.liteli1507a20171026.bean.Bean;

import com.exbawei.liteli.liteli1507a20171026.onclitener.OnClickRecyclerListner;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.ArrayList;
import java.util.List;



/**
 * Created by li te li on 2017/10/26.
 */

public class Myadapter extends RecyclerView.Adapter<Myadapter.ViewHolder> {
    List<Bean.DataBean.ComicsBean> list = new ArrayList<>();
    Context context;
    private final ImageLoader instance;
    private final DisplayImageOptions options;
    String url="http://tingapi.ting.baidu.com/v1/restserver/ting?method=baidu.ting.billboard.billList&type=1&size=10&offset=0 ";
   //构造器
    public Myadapter(List<Bean.DataBean.ComicsBean> list,Context context) {
      this.list=list;
        this.context=context;
        //ImageLoader
        instance = ImageLoader.getInstance();
        ImageLoaderConfiguration configuration = ImageLoaderConfiguration.createDefault(context);
        instance.init(configuration);
        //配置默认图片，加载中图片，加载错误时图片 磁盘缓存，内存缓存
        options = new DisplayImageOptions.Builder()
                .cacheOnDisk(true)
                .cacheInMemory(true)
                .showImageForEmptyUri(R.mipmap.ic_launcher)
                .showImageOnLoading(R.drawable.aa)
                .showImageOnFail(R.drawable.bb)
                .build();
    }

    @Override
    public Myadapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view =View.inflate(context,R.layout.item,null);
        final ViewHolder viewHolder = new ViewHolder(view);
        if (lister !=null){
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    lister.onItemClick(view,viewHolder.getLayoutPosition());
                }
            });
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(Myadapter.ViewHolder holder, int position) {
        //赋值
     holder.tv1.setText(list.get(position).getTitle());
        holder.tv2.setText(list.get(position).getLabel_text());
        Glide.with(context).load(list.get(position).getCover_image_url()).into(holder.iv);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
       //viewHolder
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iv;
        TextView tv1;
        TextView tv2;

        public ViewHolder(View itemView) {
            super(itemView);
            iv= (ImageView) itemView.findViewById(R.id.iv);
            tv1= (TextView) itemView.findViewById(R.id.textView);
            tv2= (TextView) itemView.findViewById(R.id.textView2);


        }
    }
    //实现点击事件
    OnClickRecyclerListner lister;
    public void setLister(OnClickRecyclerListner listner){
        this.lister=listner;
    }
}
